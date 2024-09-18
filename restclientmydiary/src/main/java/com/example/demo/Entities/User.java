package com.example.demo.Entities;

public class User {

	long id;
	String username;
	String password;
	String role;
	boolean enabled;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String BCRYPT(String password)
	{
		return password;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = BCRYPT(password);
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnable() {
		return enabled;
	}
	public void setEnable() {
		this.enabled = true;
	}

}
