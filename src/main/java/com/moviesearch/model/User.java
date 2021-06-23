package com.moviesearch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name="users")
@Component
public class User {
	@Id
    private int id;

	private String username;
	private String fullname;
	private String email;
	private String password;
	private int role;
	
	public User()
	{
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
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
	public User(@NotBlank(message = "UserName cannot be Null") String username,
			@NotBlank(message = "Full Name cannot be Null") String fullname,
			@NotBlank(message = "email cannot be Null") String email,
			@NotBlank(message = "password cannot be Null") String password) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.role=0;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", fullname=" + fullname + ", email=" + email
				+ ", password=" + password + "]";
	}


}