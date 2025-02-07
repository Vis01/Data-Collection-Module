package com.cdac.Acts.dto;

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
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


