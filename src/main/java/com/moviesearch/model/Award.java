package com.moviesearch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="award")
public class Award {
	@Id
	@Column(name="awardId")
	private int awardId;
	@Column(name="awardName")
	private String awardName;

	public Award() {
		super();
	}
	public Award(int awardId, String awardName) {
		super();
		this.awardId = awardId;
		this.awardName = awardName;
	}
	public int getawardId() {
		return awardId;
	}
	public void setawardId(int awardId) {
		this.awardId = awardId;
	}
	public String getawardName() {
		return awardName;
	}
	public void setawardName(String awardName) {
		this.awardName = awardName;
	}
	
}
