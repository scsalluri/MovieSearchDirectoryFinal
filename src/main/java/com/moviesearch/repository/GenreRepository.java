package com.moviesearch.repository;
import org.springframework.data.repository.CrudRepository;

import com.moviesearch.model.Genre;

	public interface GenreRepository extends CrudRepository<Genre, Integer> {

	public Genre findByGenreName(String GenreName);
	
	}
