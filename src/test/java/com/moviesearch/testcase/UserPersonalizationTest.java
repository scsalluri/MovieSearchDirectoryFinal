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

import com.moviesearch.model.UserPersonalization;
import com.moviesearch.repository.UserPersonalizationRepository;

import com.moviesearch.service.UserPersonalizationService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPersonalizationTest {

	@Autowired
	private UserPersonalizationService service;

	@MockBean
	private UserPersonalizationRepository repository;

	@Test
	public void getAllMovieGenreTest() 
	{
		when(repository.findAll()).thenReturn(Stream.of(new UserPersonalization(1,2,3,5)).collect(Collectors.toList()));
		assertEquals(1, service.getAlluserPersonalizations().size());
	}

	@Test
	public void getMoviesByGenreIdTest() 
	{
		int GenreId = 3;
		UserPersonalization userPersonalization=new UserPersonalization(1,2,4,GenreId);
		when(repository.findByGenreId(GenreId)).thenReturn(userPersonalization);		
		assertEquals(userPersonalization, service.getByGenreId(GenreId));
	}

	@Test
	public void saveUserTest() 
	{
		UserPersonalization userPersonalization = new UserPersonalization(1,2,5,4);
		when(repository.save(userPersonalization)).thenReturn(userPersonalization);
		assertEquals(userPersonalization, service.saveuserPersonalization(userPersonalization));
	}

	
	
	







}
