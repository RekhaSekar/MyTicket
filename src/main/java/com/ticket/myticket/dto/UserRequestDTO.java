package com.ticket.myticket.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserRequestDTO {
	@NotBlank(message = "Name cannot be null")
	private String name;

	@NotBlank(message = "Email cannot be null")
	private String email;

	private String department;

	@NotNull(message = "Password cannot be null")
	@Length(max = 16, min = 8, message = "Password shouid have minimum of 8 and maximum of 16 characters")
	private String password;

	@NotNull(message = "Confirm Password cannot be null")
	private String confirmPassword;

	public UserRequestDTO(@NotBlank(message = "Name cannot be null") String name,
			@NotBlank(message = "Email cannot be null") String email, String department,
			@NotNull(message = "Password cannot be null") @Length(max = 16, min = 8, message = "Password shouid have minimum of 8 and maximum of 16 characters") String password,
			@NotNull(message = "Confirm Password cannot be null") String confirmPassword) {
		super();
		this.name = name;
		this.email = email;
		this.department = department;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public UserRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
