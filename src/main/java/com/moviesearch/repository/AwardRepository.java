package com.moviesearch.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.moviesearch.model.Award;

	public interface AwardRepository extends CrudRepository<Award, Integer> {

	public Award findByAwardName(String AwardName);
	public List<Award> findAll();
	public Award findByAwardId(int aid);
	}
