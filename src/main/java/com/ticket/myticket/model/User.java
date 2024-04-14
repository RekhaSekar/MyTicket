package com.ticket.myticket.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T_USER")
public class User {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;

	@Column(name = "DEPARTMENT")
	private String department;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ACTIVE")
	private boolean isActive;

	@Column(name = "ROLE")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "uid"))
	private Set<String> roles;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String email, String department, String password, boolean isActive,
			Set<String> roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.password = password;
		this.isActive = isActive;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}
