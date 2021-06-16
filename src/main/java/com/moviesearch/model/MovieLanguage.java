package com.moviesearch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="movie_Language")
public class MovieLanguage {
	@Id
	private int serialNo;
	private int movieId;
	private int languageId;
	public MovieLanguage(int serialNo,int movieId, int languageId) {
		super();
		this.serialNo=serialNo;
		this.movieId = movieId;
		this.languageId = languageId;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public MovieLanguage() {
		super();
	}
	
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int LanguageId) {
		this.languageId = LanguageId;
	}
	public int getmovieId() {
		return movieId;
	}
	public void setmovieId(int movieId) {
		this.movieId = movieId;
	}
	
}
