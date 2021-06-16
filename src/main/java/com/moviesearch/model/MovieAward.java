package com.moviesearch.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="movieAward")
public class MovieAward {
@Id
private int sno;
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public int getMovieId() {
	return movieId;
}
public void setMovieId(int movieId) {
	this.movieId = movieId;
}
public int getAwardId() {
	return awardId;
}
public void setAwardId(int awardId) {
	this.awardId = awardId;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public MovieAward() {
	super();
}
public MovieAward(int sno, int movieId, int awardId, String category) {
	super();
	this.sno = sno;
	this.movieId = movieId;
	this.awardId = awardId;
	this.category = category;
}
private int movieId;
private int awardId;
private String category;

}
