package com.example.user.JWT;

public class JwtResponse {
	
	
	private String userName;
	private String password;
	private String roles;
	private String status;
	
	public JwtResponse(String userName, String password, String roles, String status) {
		super();
		this.userName = userName;
		this.password = password;
		this.roles = roles;
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
