package com.moviesearch.repository;

import org.springframework.data.repository.CrudRepository;

import com.moviesearch.model.Movie;


public interface MovieRepository extends CrudRepository<Movie, Integer> {


}
