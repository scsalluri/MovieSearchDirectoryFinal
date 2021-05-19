package com.moviesearch.service;

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
}
