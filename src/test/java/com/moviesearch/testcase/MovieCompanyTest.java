package com.moviesearch.testcase;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.moviesearch.repository.MovieCompanyRepository;

import com.moviesearch.model.MovieCompany;

import com.moviesearch.service.MovieCompanyService;




@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieCompanyTest {

	@Autowired
	private MovieCompanyService service;

	@MockBean
	private MovieCompanyRepository repository;

	@Test
	public void getAllMovieCompanyTest() 
	{
		when(repository.findAll()).thenReturn(Stream.of(new MovieCompany(1,2,3),new MovieCompany(3,4,6)).collect(Collectors.toList()));
		assertEquals(2, service.getAllMovieCompany().size());
	}

	
	@Test
	public void saveMovieCompany() 
	{
		MovieCompany movieCompany = new MovieCompany(2,5,7);
		when(repository.save(movieCompany)).thenReturn(movieCompany);
		assertEquals(movieCompany, service.saveMovieCompany(movieCompany));
	}
	
	@Test
	public void deleteMovieCompanyTest() 
	{
		MovieCompany movieCompany=new MovieCompany(3,4,6);
		service.removeMovieCompany(movieCompany);
		verify(repository, times(1)).delete(movieCompany);
	}

	


}

