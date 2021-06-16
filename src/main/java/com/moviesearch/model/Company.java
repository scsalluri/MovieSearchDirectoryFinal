package com.moviesearch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="company")
public class Company {
	@Id
	private int companyId;
	private String companyName;
	
	public Company() {
		super();
	}
	public Company(int companyId, String companyName) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
}
