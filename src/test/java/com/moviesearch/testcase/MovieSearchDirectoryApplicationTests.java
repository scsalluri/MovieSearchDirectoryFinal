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

import com.moviesearch.repository.UserRepository;
import com.moviesearch.model.User;
import com.moviesearch.service.UserService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieSearchDirectoryApplicationTests {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	@Test
	public void getAllUsersTest() 
	{
		when(repository.findAll()).thenReturn(Stream.of(new User("niharika", "niharika nayak", "niharika@gmail.com", "Salloori@1"),new User("achieve", "achieve patnaik", "achieve@gmail.com", "Salloori@1")).collect(Collectors.toList()));
		assertEquals(2, service.getAllUsers().size());
	}

	@Test
	public void getUserByUsernameTest() 
	{
		String username = "niharika";
		User user=new User(username, "niharika nayak", "niharika@gmail.com", "Salloori@1");
		when(repository.findByUsername(username)).thenReturn(user);		
		assertEquals(user, service.findByUsername(username));
	}

	@Test
	public void saveUserTest() 
	{
		User user = new User("niharika", "niharika nayak", "niharika@gmail.com", "Salloori@1");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.saveMyUser(user));
	}

	@Test
	public void getUserByEmailTest()
	{
		String email="niharika@gmail.com";
		User user=new User("niharika","niharika nayak",email,"Salloori@1");
		when(repository.findByEmail(email)).thenReturn(user);
		assertEquals(user, service.findByEmail(email));
	}
	
	@Test
	public void getUserByUsernameAndPasswordTest()
	{
		String username="niharika01";
		String password="Salloori@1";
		User user=new User("niharika",username,"niharika@gmail.com",password);
		when(repository.findByUsernameAndPassword(username, password)).thenReturn(user);
		assertEquals(user, service.findByUsernameAndPassword(username, password));
	}
	
	


}
