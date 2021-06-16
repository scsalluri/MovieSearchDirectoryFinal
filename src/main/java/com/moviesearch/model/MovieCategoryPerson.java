package com.moviesearch.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="MovieCategoryPerson")
public class MovieCategoryPerson {
	@Id
	private int serialNo;
	private int MovieId;
	private int categoryId;
	private int personId;
	
	public int getMovieId() {
		return MovieId;
	}
	public void setMovieId(int movieId) {
		MovieId = movieId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public MovieCategoryPerson(int serialNo,int movieId, int categoryId, int personId) {
		super();
		this.serialNo=serialNo;
		this.MovieId = movieId;
		this.categoryId = categoryId;
		this.personId = personId;
	}
	public MovieCategoryPerson() {
		super();
	}

	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	

	
}
