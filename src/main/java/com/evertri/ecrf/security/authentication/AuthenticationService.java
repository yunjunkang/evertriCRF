package com.evertri.ecrf.security.authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

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

    // Checks if the given username and MAC address are authorized
    public boolean isAuthorized(String username, String macAddress) {
        return isUserAuthorized(username) && isDeviceAuthorized(macAddress);
    }

    // Checks if the given username is authorized
    private boolean isUserAuthorized(String username) {
        // Make a request to the user database to verify the authenticity of the user
        // ...

        // Parse the response from the user database
        // ...

        // Return true if the user is authorized, false otherwise
        return true;
    }

    // Checks if the given MAC address is authorized
    private boolean isDeviceAuthorized(String macAddress) {
        // Make a request to the device database to verify the authenticity of the device
        // ...

        // Parse the response from the device database
        // ...

        // Return true if the device is authorized, false otherwise
        return true;
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
