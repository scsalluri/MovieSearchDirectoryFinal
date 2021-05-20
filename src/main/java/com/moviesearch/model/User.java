package com.moviesearch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Entity
@Table(name="users")
@Component
public class User {
	@Id
private int id;
	@NotBlank(message="UserName cannot be Null")
	private String username;
	@NotBlank(message="Full Name cannot be Null")
	private String fullname;
	@NotBlank(message="email cannot be Null")
	private String email;
	@NotBlank(message="password cannot be Null")
	private String password;
	public User()
	{
		
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
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", fullname=" + fullname + ", email=" + email
				+ ", password=" + password + "]";
	}


}
