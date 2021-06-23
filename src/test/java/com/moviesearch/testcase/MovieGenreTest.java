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

import com.moviesearch.repository.MovieGenreRepository;

import com.moviesearch.model.MovieGenre;

import com.moviesearch.service.MovieGenreService;




@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieGenreTest {

	@Autowired
	private MovieGenreService service;

	@MockBean
	private MovieGenreRepository repository;

	@Test
	public void getAllMovieGenresTest() 
	{
		when(repository.findAll()).thenReturn(Stream.of(new MovieGenre(1,2,3),new MovieGenre(3,4,6)).collect(Collectors.toList()));
		assertEquals(2, service.getAllMovieGenres().size());
	}

	
	@Test
	public void saveMovieGenre() 
	{
		MovieGenre movieGenre = new MovieGenre(2,5,7);
		when(repository.save(movieGenre)).thenReturn(movieGenre);
		assertEquals(movieGenre, service.saveMovieGenre(movieGenre));
	}
	
	@Test
	public void deleteUserTest() 
	{
		MovieGenre movieGenre=new MovieGenre(3,4,6);
		service.removeMovieGenre(movieGenre);;
		verify(repository, times(1)).delete(movieGenre);
	}

	


}
