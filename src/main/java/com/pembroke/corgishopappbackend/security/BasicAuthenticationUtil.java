package com.pembroke.corgishopappbackend.security;

public class BasicAuthenticationUtil {

    public static String getBasicAuthenticationHeader(String username, String password) {
        return "Basic " + java.util.Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
    }

}
