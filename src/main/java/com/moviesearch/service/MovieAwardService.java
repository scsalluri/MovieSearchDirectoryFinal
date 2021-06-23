package com.moviesearch.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.moviesearch.model.MovieAward;
import com.moviesearch.model.MovieCategoryPerson;
import com.moviesearch.repository.MovieAwardRepository;
@Service
@Transactional
public class MovieAwardService {
	private final MovieAwardRepository movieAwardRepository;
	public MovieAwardService (MovieAwardRepository movieAwardRepository)
	{
		this.movieAwardRepository=movieAwardRepository;
	}

public List<MovieAward> getAllMovieAwards() {
	return (List<MovieAward>) movieAwardRepository.findAll();
}
public MovieAward saveMovieAward(MovieAward lang) {
	return movieAwardRepository.save(lang);
	
}
public void removeMovieAward(MovieAward values) {
	// TODO Auto-generated method stub
	movieAwardRepository.delete(values);
}


}
