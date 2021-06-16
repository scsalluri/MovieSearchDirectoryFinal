package com.moviesearch.service;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.moviesearch.model.MovieCompany;

import com.moviesearch.repository.MovieCompanyRepository;

@Service
@Transactional
public class MovieCompanyService {
	private final MovieCompanyRepository movieCompanyRepository;
	public MovieCompanyService (MovieCompanyRepository movieCompanyRepository)
	{
		this.movieCompanyRepository=movieCompanyRepository;
	}

	public void saveMovieCompany(MovieCompany movieCompany)
	{
	movieCompanyRepository.save(movieCompany);
	}
	public List<MovieCompany> getAllMovieCompany() {
		return (List<MovieCompany>) movieCompanyRepository.findAll();
	}

	public void removeMovieCompany(MovieCompany values) {
		// TODO Auto-generated method stub
		movieCompanyRepository.delete(values);
	}


}
