package com.ticket.myticket.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequestDTO {
	@JsonProperty("userName")
	private String email;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("refresh_token")
	private String refreshToken;

	public LoginRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginRequestDTO(String email, String password, String refreshToken) {
		super();
		this.email = email;
		this.password = password;
		this.refreshToken = refreshToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
}
