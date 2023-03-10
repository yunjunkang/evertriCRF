package com.evertri.ecrf.security.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    // This method handles HTTP GET requests to /authenticate, which authenticates the user
    @GetMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestParam("username") String username,
                                               @RequestParam("macAddress") String macAddress,
                                               @RequestParam("studyId") Long studyId) {
        // Check if the user is authorized by the authentication service
        if (authenticationService.isAuthorized(username, macAddress, studyId)) {
            // Generate a token for the user
            String token = authenticationService.generateToken(username);
            // Return a response entity with the token and a status code of OK
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            // Return a response entity with a status code of UNAUTHORIZED
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
