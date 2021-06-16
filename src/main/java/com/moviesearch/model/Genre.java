package com.moviesearch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Genre")
public class Genre {
	@Id
	private int genreId;
	private String genreName;
	
	public Genre() {
		super();
	}
	public Genre(int genreId, String genreName) {
		super();
		this.genreId = genreId;
		this.genreName = genreName;
	}
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int GenreId) {
		this.genreId = GenreId;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String GenreName) {
		this.genreName = GenreName;
	}

	
}
