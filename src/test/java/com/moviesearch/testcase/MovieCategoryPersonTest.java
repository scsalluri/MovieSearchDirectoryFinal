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

import com.moviesearch.repository.MovieCategoryPersonRepository;

import com.moviesearch.model.MovieCategoryPerson;

import com.moviesearch.service.MovieCategoryPersonService;




@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieCategoryPersonTest {

	@Autowired
	private MovieCategoryPersonService service;

	@MockBean
	private MovieCategoryPersonRepository repository;

	@Test
	public void getAllMovieCategoryTest() 
	{
		when(repository.findAll()).thenReturn(Stream.of(new MovieCategoryPerson(1,2,3,7),new MovieCategoryPerson(3,4,6,2)).collect(Collectors.toList()));
		assertEquals(2, service.findall().size());
	}

	
	@Test
	public void saveMovieCompany() 
	{
		MovieCategoryPerson movieCategoryPerson = new MovieCategoryPerson(2,5,3,2);
		when(repository.save(movieCategoryPerson)).thenReturn(movieCategoryPerson);
		assertEquals(movieCategoryPerson, service.saveMovieCategoryPersonService(movieCategoryPerson));
	}
	
	@Test
	public void deleteMovieCompanyTest() 
	{
		MovieCategoryPerson movieCategoryPerson=new MovieCategoryPerson(3,4,6,2);
		service.removeMovieCategoryPerson(movieCategoryPerson);
		verify(repository, times(1)).delete(movieCategoryPerson);
	}
}

	