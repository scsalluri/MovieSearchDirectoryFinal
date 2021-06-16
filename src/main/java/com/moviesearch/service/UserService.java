package com.moviesearch.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.moviesearch.model.User;
import com.moviesearch.repository.UserRepository;

@Service
@Transactional
public class UserService {
	private final UserRepository userRepository;
	public UserService (UserRepository userRepository)
	{
		this.userRepository=userRepository;
	}
public void saveMyUser(User user)
{
userRepository.save(user);	
}
public User findByUsernameAndPassword(String username,String password)
{
 return userRepository.findByUsernameAndPassword(username, password);
}
public User findByUsername(String username)
{
 return userRepository.findByUsername(username);	
}
public User findByEmail(String email)
{
 return userRepository.findByEmail(email);	
}
public List<User> getAllUsers()
{
 return  (List<User>) userRepository.findAll();	
}
}
