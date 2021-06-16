package com.moviesearch.repository;
import org.springframework.data.repository.CrudRepository;

import com.moviesearch.model.MovieGenre;

	public interface MovieGenreRepository extends CrudRepository<MovieGenre, Integer> {
	
	}
