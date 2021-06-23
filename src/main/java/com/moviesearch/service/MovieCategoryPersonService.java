package com.moviesearch.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.moviesearch.model.MovieCategoryPerson;
import com.moviesearch.repository.MovieCategoryPersonRepository;


@Service
@Transactional
public class MovieCategoryPersonService {
	private final MovieCategoryPersonRepository movieCategoryPersonRepository;
	public MovieCategoryPersonService (MovieCategoryPersonRepository movieCategoryPersonRepository)
	{
		this.movieCategoryPersonRepository=movieCategoryPersonRepository;
	}

	public MovieCategoryPerson saveMovieCategoryPersonService(MovieCategoryPerson mcp)
	{
	  return movieCategoryPersonRepository.save(mcp);
	}
	
	
	public List<MovieCategoryPerson> findall()
	{
	 return	(List<MovieCategoryPerson>) movieCategoryPersonRepository.findAll();
	}

	public void removeMovieCategoryPerson(MovieCategoryPerson values) {
		// TODO Auto-generated method stub
		movieCategoryPersonRepository.delete(values);
	}

}
