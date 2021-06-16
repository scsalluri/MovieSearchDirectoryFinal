package com.moviesearch.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import com.moviesearch.model.MovieGenre;
import com.moviesearch.repository.MovieGenreRepository;

@Service
@Transactional
public class MovieGenreService {
	private final MovieGenreRepository movieGenreRepository;
	public MovieGenreService (MovieGenreRepository movieGenreRepository)
	{
		this.movieGenreRepository=movieGenreRepository;
	}

	public void saveMovieGenre(MovieGenre movieGenre)
	{
	movieGenreRepository.save(movieGenre);
	}

	public List<MovieGenre> getAllMovieGenres() {
		return (List<MovieGenre>) movieGenreRepository.findAll();
	}

	public void removeMovieGenre(MovieGenre values) {
		// TODO Auto-generated method stub
		movieGenreRepository.delete(values);
		
	}

}
