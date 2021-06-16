package com.moviesearch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="movie_Genre")
public class MovieGenre {
	@Id
	private int serialNo;
	private int movieId;
	private int genreId;
	public MovieGenre(int serialNo,int movieId, int GenreId) {
		super();
		this.serialNo=serialNo;
		this.movieId = movieId;
		this.genreId = GenreId;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public MovieGenre() {
		super();
	}

	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int GenreId) {
		this.genreId = GenreId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	
}
