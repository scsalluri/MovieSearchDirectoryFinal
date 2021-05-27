package com.moviesearch.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.moviesearch.model.Movie;
import com.moviesearch.repository.MovieRepository;

@Service
@Transactional
public class MovieService {
	private final MovieRepository movieRepository;
	public MovieService (MovieRepository movieRepository)
	{
		this.movieRepository=movieRepository;
	}
public void saveMovie(Movie movie)
{
movieRepository.save(movie);	
}
}
