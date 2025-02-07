package com.cdac.Acts.dto;

<<<<<<< HEAD
public class LoginResponse {

    private String token;
    private String username;
    private String role;
    private Long userId;

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	// Constructor
    public LoginResponse(String token, String username, String role,Long userId) {
        this.token = token;
        this.username = username;
        this.role = role;
        this.userId=userId;
    }

    // Getter and Setter for token
=======
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
>>>>>>> 6c116af2847faee897a2dfaf71c19c1e9e050611
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

<<<<<<< HEAD
    // Getter and Setter for username
=======
>>>>>>> 6c116af2847faee897a2dfaf71c19c1e9e050611
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

<<<<<<< HEAD
    // Getter and Setter for role
=======
>>>>>>> 6c116af2847faee897a2dfaf71c19c1e9e050611
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


