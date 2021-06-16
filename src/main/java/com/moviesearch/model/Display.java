package com.moviesearch.model;

import java.util.List;

public class Display {
private List<Movies> movies;
private List<String> imgs;
public List<Movies> getMovies() {
	return movies;
}
public void setMovies(List<Movies> movies) {
	this.movies = movies;
}
public List<String> getImgs() {
	return imgs;
}
public void setImgs(List<String> imgs) {
	this.imgs = imgs;
}
public Display(List<Movies> movies, List<String> imgs) {
	super();
	this.movies = movies;
	this.imgs = imgs;
}


}
