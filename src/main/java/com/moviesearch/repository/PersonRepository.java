package com.moviesearch.repository;
import org.springframework.data.repository.CrudRepository;

import com.moviesearch.model.Person;

	public interface PersonRepository extends CrudRepository<Person, Integer> {

	public Person findByPersonName(String PersonName);
	public Person findByPersonId(int PersonId);
	}
