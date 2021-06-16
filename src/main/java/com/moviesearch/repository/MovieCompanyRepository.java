package com.moviesearch.repository;
import org.springframework.data.repository.CrudRepository;

import com.moviesearch.model.MovieCompany;

	public interface MovieCompanyRepository extends CrudRepository<MovieCompany, Integer> {
	
	}
