package com.moviesearch.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="person")
public class Person {
	@Id
	private int personId;
	private String personName;
	private byte[] personImage;
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public byte[] getPersonImage() {
		return personImage;
	}
	public void setPersonImage(byte[] personImage) {
		this.personImage = personImage;
	}
	public Person(int personId, String personName, byte[] personImage) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personImage = personImage;
	}
	public Person() {
		super();
	}

	
}
