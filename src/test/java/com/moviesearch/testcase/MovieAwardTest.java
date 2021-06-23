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

import com.moviesearch.repository.MovieAwardRepository;

import com.moviesearch.model.MovieAward;

import com.moviesearch.service.MovieAwardService;




@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieAwardTest {

	@Autowired
	private MovieAwardService service;

	@MockBean
	private MovieAwardRepository repository;

	@Test
	public void getAllMovieAwardTest() 
	{
		when(repository.findAll()).thenReturn(Stream.of(new MovieAward(2,3,4,"Best actor"),new MovieAward(3,4,6,"Best actor in supportive role")).collect(Collectors.toList()));
		assertEquals(2, service.getAllMovieAwards().size());
	}

	
	@Test
	public void saveMovieAward() 
	{
		MovieAward movieAward = new MovieAward(2,5,7,"Best actress");
		when(repository.save(movieAward)).thenReturn(movieAward);
		assertEquals(movieAward, service.saveMovieAward(movieAward));
	}
	
	@Test
	public void deleteMovieAwardTest() 
	{
		MovieAward movieAward=new MovieAward(3,4,6,"Best ");
		service.removeMovieAward(movieAward);
		verify(repository, times(1)).delete(movieAward);
	}

	


}

