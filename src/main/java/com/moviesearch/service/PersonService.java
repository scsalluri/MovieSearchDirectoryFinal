package com.moviesearch.service;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.moviesearch.model.Person;

import com.moviesearch.repository.PersonRepository;
@Service
@Transactional
public class PersonService {
	private final PersonRepository personRepository;
	public PersonService (PersonRepository personRepository)
	{
		this.personRepository=personRepository;
	}
public Person findBypersonName(String personName)
{
	return personRepository.findByPersonName(personName);
}
public List<Person> getAllpersons() {
	return (List<Person>) personRepository.findAll();
}
public Person findByPersonId(int PersonId)
{
	return personRepository.findByPersonId(PersonId);
}
public void SaveyPerson(Person person)
{
	 personRepository.save(person);
}
}
