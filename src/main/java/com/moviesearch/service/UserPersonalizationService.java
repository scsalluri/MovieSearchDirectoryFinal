package com.moviesearch.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.moviesearch.model.UserPersonalization;

import com.moviesearch.repository.UserPersonalizationRepository;
@Service
@Transactional
public class UserPersonalizationService {
	private final UserPersonalizationRepository userPersonalizationRepository;
	public UserPersonalizationService (UserPersonalizationRepository userPersonalizationRepository)
	{
		this.userPersonalizationRepository=userPersonalizationRepository;
	}

public List<UserPersonalization> getAlluserPersonalizations() {
	return (List<UserPersonalization>) userPersonalizationRepository.findAll();
}
public void saveuserPersonalization(UserPersonalization userpersaonalization) {
	userPersonalizationRepository.save(userpersaonalization);
	
}


}
