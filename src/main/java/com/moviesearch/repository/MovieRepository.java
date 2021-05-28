package com.moviesearch.repository;

import org.springframework.data.repository.CrudRepository;

import com.moviesearch.model.Movies;


public interface MovieRepository extends CrudRepository<Movies, Integer> {

public Movies findByMovieName(String movieName);
}
