package com.moviesearch.model;

import java.sql.Date;

public class AllMovieDetailsPojo {
	private String movieName;
	private String tagline;
	private String plot;
	private byte[] poster;
	private int runtime;
	private int no_of_user;
	private int user_rating;
	private String trailer;
	private java.sql.Date release_date;
	private String language;
	private String genre;
	private String company;
	private String cast;
	private String director;
	private String producer;
	private String awards;
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public AllMovieDetailsPojo(String movieName, String tagline, String plot, byte[] poster, int runtime,
			int no_of_user, int user_rating, String trailer, Date release_date, String language, String genre,
			String company, String cast, String director, String producer) {
		super();
		this.movieName = movieName;
		this.tagline = tagline;
		this.plot = plot;
		this.poster = poster;
		this.runtime = runtime;
		this.no_of_user = no_of_user;
		this.user_rating = user_rating;
		this.trailer = trailer;
		this.release_date = release_date;
		this.language = language;
		this.genre = genre;
		this.company = company;
		this.cast = cast;
		this.director = director;
		this.producer = producer;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
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
	public byte[] getPoster() {
		return poster;
	}
	public void setPoster(byte[] poster) {
		this.poster = poster;
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
	public java.sql.Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(java.sql.Date release_date) {
		this.release_date = release_date;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public AllMovieDetailsPojo() {
		super();
	}
	
	
	
	
}
