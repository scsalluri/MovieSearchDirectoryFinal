package com.moviesearch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="UserRating")
public class UserRating {
@Id
private int sno;
private int userId;
private int movieId;
private int rating;
public UserRating() {
	super();
}
public UserRating(int sno, int userId, int movieId, int rating, String comment) {
	super();
	this.sno = sno;
	this.userId = userId;
	this.movieId = movieId;
	this.rating = rating;
	this.comment = comment;
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
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
private String comment;
}
