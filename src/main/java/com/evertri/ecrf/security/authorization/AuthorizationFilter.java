package com.evertri.ecrf.security.authorization;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthorizationFilter implements Filter {
    private Map<String, String> authorizedMacAddresses;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialize the authorizedMacAddresses map with the pre-authorized MAC addresses
        authorizedMacAddresses = new HashMap<>();
        authorizedMacAddresses.put("00:11:22:33:44:55", "Tablet 1");
        authorizedMacAddresses.put("11:22:33:44:55:66", "Tablet 2");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Get the MAC address of the device making the request
        String clientMacAddress = getClientMacAddress(httpRequest);

        // Check if the MAC address is authorized
        if (authorizedMacAddresses.containsKey(clientMacAddress)) {
            // If the MAC address is authorized, allow the request to continue
            chain.doFilter(request, response);
        } else {
            // If the MAC address is not authorized, send a Forbidden response
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
        }
    }

    @Override
    public void destroy() {
    }

    private String getClientMacAddress(HttpServletRequest request) {
        // Code to get the MAC address of the device making the request
        // This code would depend on the platform and environment you are running in
        // For example, in a JavaEE environment, you can use the HttpServletRequest object to get the client's MAC address
        // However, this is not guaranteed to work in all environments and may not be reliable
        // You may need to implement a different solution for getting the client's MAC address, depending on your setup
        return "";
    }
}
