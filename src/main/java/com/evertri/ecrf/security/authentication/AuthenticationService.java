package com.evertri.ecrf.security.authentication;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean isAuthorized(String username) {
        return isUserAuthorized(username) && isDeviceAuthorized(macAddress);
    }

    private boolean isUserAuthorized(String username) {
        // Make a request to the external API to verify the authenticity of the user
        // ...

        // Parse the response from the external API
        // ...

        // Return true if the user is authorized, false otherwise
        return true;
    }

    private boolean isDeviceAuthorized(String macAddress) {
        // Make a request to the external API to verify the authenticity of the device
        // ...

        // Parse the response from the external API
        // ...

        // Return true if the device is authorized, false otherwise
        return true;
    }
}
