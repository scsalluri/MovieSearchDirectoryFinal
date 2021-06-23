package com.moviesearch.testcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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

import com.moviesearch.repository.AwardRepository;

import com.moviesearch.model.Award;

import com.moviesearch.service.AwardService;




@RunWith(SpringRunner.class)
@SpringBootTest
public class AwardTest {

	@Autowired
	private AwardService service;

	@MockBean
	private AwardRepository repository;

	@Test
	public void getAllAwardTest() 
	{
		when(repository.findAll()).thenReturn(Stream.of(new Award(2,"IIFA"),new Award(6,"Star Dust")).collect(Collectors.toList()));
		assertEquals(2, service.getAllAwards().size());
	}

	
	@Test
	public void saveAward() 
	{
		Award award = new Award(3,"Oscar");
		when(repository.save(award)).thenReturn(award);
		assertEquals(award, service.saveAward(award));
	}
	
	@Test
	public void findByAwardIdTest() 
	{
		int aid=1;
		Award award=new Award(aid,"Filmfare");
		when(repository.findByAwardId(aid)).thenReturn(award);
		assertEquals(award,service.findByAwardId(aid));
		
	}
	
	@Test
	public void findByAwardNameTest() 
	{
		String awardName="Golden Globe Awards";
		Award award=new Award(4,awardName);
		when(repository.findByAwardName(awardName)).thenReturn(award);
		assertEquals(award,service.findByAwardName(awardName));
		
	}

	


}

