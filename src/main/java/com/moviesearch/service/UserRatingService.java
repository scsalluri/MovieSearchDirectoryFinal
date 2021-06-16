package com.moviesearch.service;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.moviesearch.model.UserRating;
import com.moviesearch.repository.UserRatingRepository;



@Service
@Transactional
public class UserRatingService {
	private final UserRatingRepository userRatingRepository;
	public UserRatingService (UserRatingRepository userRatingRepository)
	{
		this.userRatingRepository=userRatingRepository;
	}

public List <UserRating> getAllUserRatings() {
	return (List<UserRating>) userRatingRepository.findAll();
}
public void saveUserRating(UserRating gen) {
	userRatingRepository.save(gen);
	// TODO Auto-generated method stub
	
}
}
