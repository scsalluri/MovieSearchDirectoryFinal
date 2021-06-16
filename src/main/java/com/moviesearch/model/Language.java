package com.moviesearch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="language")
public class Language {
	@Id
	@Column(name="languageId")
	private int languageId;
	@Column(name="languageName")
	private String languageName;

	public Language() {
		super();
	}
	public Language(int languageId, String languageName) {
		super();
		this.languageId = languageId;
		this.languageName = languageName;
	}
	public int getlanguageId() {
		return languageId;
	}
	public void setlanguageId(int languageId) {
		this.languageId = languageId;
	}
	public String getlanguageName() {
		return languageName;
	}
	public void setlanguageName(String languageName) {
		this.languageName = languageName;
	}
	
}
