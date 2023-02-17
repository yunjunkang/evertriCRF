package com.evertri.ecrf.security.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private AuthenticationService authenticationService;

    // This method checks if the incoming HTTP request is authorized by checking the user's JWT token
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Get the JWT token from the HTTP request header
        String authorizationHeader = request.getHeader("Authorization");

        // If the JWT token is null or doesn't start with "Bearer ", return a response with a status code of UNAUTHORIZED
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return;
        }

        // Get the JWT token value without the "Bearer " prefix
        String jwtToken = authorizationHeader.substring(7);

        // If the JWT token is invalid, return a response with a status code of UNAUTHORIZED
        if (!authenticationService.validateToken(jwtToken)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return;
        }

        // Get the username from the JWT token
        String username = authenticationService.getUsernameFromToken(jwtToken);

        // Check if the user is authorized to access the resource
        if (authenticationService.isAuthorized(username, request.getHeader("macAddress"))) {
            filterChain.doFilter(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        }
    }
}
