package com.notifier.entities;

public class User {

	private int id;
	private String username;
	private String mobilenumber;
	private String email;
	private String password;
	private String confirm_password;
	
	public User(int id, String username, String mobilenumber, String email, String password, String confirm_password) {
		super();
		this.id = id;
		this.username = username;
		this.mobilenumber = mobilenumber;
		this.email = email;
		this.password = password;
		this.confirm_password = confirm_password;
	}
	public User() {
		
	}
	public User(String username, String mobilenumber, String email, String password, String confirm_password) {
		
		this.username = username;
		this.mobilenumber = mobilenumber;
		this.email = email;
		this.password = password;
		this.confirm_password = confirm_password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
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
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	
	
	
}
