package com.moviesearch.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.moviesearch.model.Movies;
import com.moviesearch.repository.MovieRepository;


@Service
@Transactional
public class MovieService {
	private final MovieRepository movieRepository;
	public MovieService (MovieRepository movieRepository)
	{
		this.movieRepository=movieRepository;
	}
public void saveMovie(Movies movie)
{
movieRepository.save(movie);	
}
public Movies findByMovieName(String movieName)
{
	return movieRepository.findByMovieName(movieName);
}
}
