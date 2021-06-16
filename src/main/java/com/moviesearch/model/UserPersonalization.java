package com.moviesearch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="UserPersonalization")
public class UserPersonalization {
@Id
private int sno;
private int userId;
private int movieId;
private int genreId;

public UserPersonalization() {
	super();
}
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getMovieId() {
	return movieId;
}
public void setMovieId(int movieId) {
	this.movieId = movieId;
}
public int getGenreId() {
	return genreId;
}
public void setGenreId(int genreId) {
	this.genreId = genreId;
}

public UserPersonalization(int sno, int userId, int movieId, int genreId) {
	super();
	this.sno = sno;
	this.userId = userId;
	this.movieId = movieId;
	this.genreId = genreId;

}
}
