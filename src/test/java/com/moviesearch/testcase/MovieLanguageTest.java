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

import com.moviesearch.repository.MovieLanguageRepository;

import com.moviesearch.model.MovieLanguage;

import com.moviesearch.service.MovieLanguageService;




@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieLanguageTest {

	@Autowired
	private MovieLanguageService service;

	@MockBean
	private MovieLanguageRepository repository;

	@Test
	public void getAllMovieLanguagesTest() 
	{
		when(repository.findAll()).thenReturn(Stream.of(new MovieLanguage(1,2,3),new MovieLanguage(3,4,6)).collect(Collectors.toList()));
		assertEquals(2, service.getAllMovieLanguage().size());
	}

	
	@Test
	public void saveMovieLanguage() 
	{
		MovieLanguage movieLanguage = new MovieLanguage(2,5,7);
		when(repository.save(movieLanguage)).thenReturn(movieLanguage);
		assertEquals(movieLanguage, service.saveMovieLanguage(movieLanguage));
	}
	
	@Test
	public void deleteMovieLanguageTest() 
	{
		MovieLanguage movieLanguage=new MovieLanguage(3,4,6);
		service.removeMovieLanguage(movieLanguage);
		verify(repository, times(1)).delete(movieLanguage);
	}

	


}

