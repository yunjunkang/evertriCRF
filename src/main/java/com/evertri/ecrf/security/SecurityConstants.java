package com.evertri.ecrf.security;

public final class SecurityConstants {

    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    private SecurityConstants() {
        throw new IllegalStateException("Cannot create instance of static util class");
    }

    /**
     * Method to return the secret key used to sign the JWT token
     * @return secret key
     */
    public static String getSecret() {
        return SECRET;
    }

    /**
     * Method to return the expiration time for the JWT token
     * @return expiration time
     */
    public static long getExpirationTime() {
        return EXPIRATION_TIME;
    }

    /**
     * Method to return the token prefix
     * @return token prefix
     */
    public static String getTokenPrefix() {
        return TOKEN_PREFIX;
    }

    /**
     * Method to return the header string
     * @return header string
     */
    public static String getHeaderString() {
        return HEADER_STRING;
    }
}
