package com.cdac.Acts.dto;

// This class is used to map the login response JSON to a Java object
public class LoginResponse {
    
    private String token;
    private String username;
    private String role;

    // Constructor
    public LoginResponse(String token, String username, String role) {
        this.token = token;
        this.username = username;
        this.role = role;
    }
    // Getter and Setter 
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


