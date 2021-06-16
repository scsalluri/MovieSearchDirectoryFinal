package com.moviesearch.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.moviesearch.model.MovieLanguage;
import com.moviesearch.repository.MovieLanguageRepository;

@Service
@Transactional
public class MovieLanguageService {
	private final MovieLanguageRepository movieLanguageRepository;
	public MovieLanguageService (MovieLanguageRepository movieLanguageRepository)
	{
		this.movieLanguageRepository=movieLanguageRepository;
	}

	public void saveMovieLanguage(MovieLanguage movieLanguage)
	{
	movieLanguageRepository.save(movieLanguage);
	}
	public List<MovieLanguage> getAllMovieLanguage() {
		return (List<MovieLanguage>) movieLanguageRepository.findAll();
	}

	public void removeMovieLanguage(MovieLanguage values) {
		// TODO Auto-generated method stub
		movieLanguageRepository.delete(values);
	}

}
