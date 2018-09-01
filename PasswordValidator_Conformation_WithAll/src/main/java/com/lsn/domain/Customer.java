package com.lsn.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class Customer {

	
	private int id;

	@NotEmpty(message = "Name Should not NotEmpty")
	private String name;

	@NotEmpty(message = "role Should not NotEmpty")
	private String role;

	@NotEmpty(message = "password Should not NotEmpty")
	private String password;

	@NotEmpty(message = "passwordconf Should not NotEmpty")
	private String passwordconf;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordconf() {
		return passwordconf;
	}

	public void setPasswordconf(String passwordconf) {
		this.passwordconf = passwordconf;
	}

}
