package com.moviesearch.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import org.springframework.stereotype.Component;

@Entity
@Table(name="movie_table")
@Component
public class Movie {
@Id
private int movie_id;
private String movie_name;
private String tagline;
private String plot;
private String poster;
private int runtime;
private int no_of_user;
private int user_rating;
private String trailer;

private java.sql.Date release_date;
public Movie( String movie_name, String tagline,String plot, String poster, Date release_date, int runtime, String trailer) {
	super();
	this.movie_name = movie_name;
	this.tagline = tagline;
	this.plot = plot;
	this.poster = poster;
	this.release_date = release_date;
	this.runtime = runtime;
	this.trailer = trailer;
}
public Movie() {
	super();
}


public int getMovie_id() {
	return movie_id;
}
public void setMovie_id(int movie_id) {
	this.movie_id = movie_id;
}
public String getMovie_name() {
	return movie_name;
}
public void setMovie_name(String movie_name) {
	this.movie_name = movie_name;
}
public String getTagline() {
	return tagline;
}
public void setTagline(String tagline) {
	this.tagline = tagline;
}
public String getPlot() {
	return plot;
}
public void setPlot(String plot) {
	this.plot = plot;
}
public String getPoster() {
	return poster;
}
public void setPoster(String poster) {
	this.poster = poster;
}
public java.sql.Date getRelease_date() {
	return release_date;
}
public void setRelease_date(java.sql.Date release_date) {
	this.release_date = release_date;
}
public int getRuntime() {
	return runtime;
}
public void setRuntime(int runtime) {
	this.runtime = runtime;
}
public int getNo_of_user() {
	return no_of_user;
}
public void setNo_of_user(int no_of_user) {
	this.no_of_user = no_of_user;
}
public int getUser_rating() {
	return user_rating;
}
public void setUser_rating(int user_rating) {
	this.user_rating = user_rating;
}
public String getTrailer() {
	return trailer;
}
public void setTrailer(String trailer) {
	this.trailer = trailer;
}

}
