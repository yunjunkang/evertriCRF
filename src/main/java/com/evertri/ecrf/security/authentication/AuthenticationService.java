package com.evertri.ecrf.security.authentication;

import com.evertri.ecrf.model.Device;
import com.evertri.ecrf.model.Study;
import com.evertri.ecrf.model.User;
import com.evertri.ecrf.repository.StudyRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.evertri.ecrf.repository.UserRepository;
import com.evertri.ecrf.repository.DeviceRepository;



@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudyRepository studyRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    // Generates a JWT token for the given username
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512, "secretKey")
                .compact();
    }

    // Validates the given JWT token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey("secretKey").parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Checks if the given username and MAC address are authorized to access the study with the given ID
    public boolean isAuthorized(String username, String macAddress, Long studyId) {
        return isUserAuthorized(username, studyId) && isDeviceAuthorized(macAddress);
    }

    protected boolean isUserAuthorized(String username, Long studyId) {
        User user = userRepository.findByUsername(username);
        Study study = studyRepository.findById(studyId).orElse(null);
        return user != null && study != null && user.hasAuthorization(study);
    }




    // Checks if the given MAC address is authorized
    private boolean isDeviceAuthorized(String macAddress) {
        // Make a request to the device database to verify the authenticity of the device
        Device device = deviceRepository.findByMacAddress(macAddress);

        // Return true if the device is authorized, false otherwise
        return device != null && device.isAuthorized();
    }

    // Extracts the username from the given JWT token
    protected String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey("secretKey")
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
