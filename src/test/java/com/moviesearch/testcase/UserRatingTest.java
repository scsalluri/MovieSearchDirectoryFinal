package com.moviesearch.testcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.moviesearch.repository.UserRatingRepository;
import com.moviesearch.model.UserRating;
import com.moviesearch.service.UserRatingService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRatingTest {

	@Autowired
	private UserRatingService service;

	@MockBean
	private UserRatingRepository repository;

	@Test
	public void getAllUserRatingsTest() 
	{
		when(repository.findAll()).thenReturn(Stream.of(new UserRating(1,2,3,4,"Good Story"),new UserRating(1,2,3,4, "Entertaining")).collect(Collectors.toList()));
		assertEquals(2, service.getAllUserRatings().size());
	}

	

	@Test
	public void saveUserRatingTest() 
	{
		UserRating UserRating = new UserRating(1,2,3,4,"Nice Movie");
		when(repository.save(UserRating)).thenReturn(UserRating);
		assertEquals(UserRating, service.saveUserRating(UserRating));
	}

	/*@Test
	public void getUserRatingByMovieId()
	{
		int movieId=2;
		UserRating UserRating=new UserRating(1,2,movieId,4,"Nice casting");
		when(repository.findbyMovieId(movieId)).thenReturn(UserRating);
		assertEquals(UserRating, service.getByMovieId(movieId));
	}*/
	
	
	
	


}

