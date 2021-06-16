package com.moviesearch.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.moviesearch.model.Award;

import com.moviesearch.repository.AwardRepository;
@Service
@Transactional
public class AwardService {
	private final AwardRepository awardRepository;
	public AwardService (AwardRepository awardRepository)
	{
		this.awardRepository=awardRepository;
	}
public Award findByAwardName(String AwardName)
{
	return awardRepository.findByAwardName(AwardName);
}
public List<Award> getAllAwards() {
	return awardRepository.findAll();
}
public void saveAward(Award lang) {
	awardRepository.save(lang);
	
}
public Award findByAwardId(int aid) {
	// TODO Auto-generated method stub
	return awardRepository.findByAwardId(aid);
	
}


}
