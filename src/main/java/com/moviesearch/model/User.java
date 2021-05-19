package com.moviesearch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
private int id;
private String username;
private String firstname;
private String lastname;
private String email;
private String password;
public int getId() {
	return id;
}
public User()
{
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
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
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
public User( String username, String firstname, String lastname, String email, String password) {
	super();
	this.username = username;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.password = password;
}
@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
			+ ", email=" + email + ", password=" + password + "]";
}

}
