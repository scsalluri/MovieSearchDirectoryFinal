package com.moviesearch.testcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.moviesearch.repository.LanguageRepository;

import com.moviesearch.model.Language;

import com.moviesearch.service.LanguageService;




@RunWith(SpringRunner.class)
@SpringBootTest
public class LanguageTest {

	@Autowired
	private LanguageService service;

	@MockBean
	private LanguageRepository repository;

	@Test
	public void getAllLanguageTest() 
	{
		when(repository.findAll()).thenReturn(Stream.of(new Language(2,"Chinese"),new Language(6,"Tamil")).collect(Collectors.toList()));
		assertEquals(2, service.getAllLanguages().size());
	}

	
	@Test
	public void saveLanguage() 
	{
		Language language = new Language(3,"Telugu");
		when(repository.save(language)).thenReturn(language);
		assertEquals(language, service.saveLanguage(language));
	}
	
	
	
	@Test
	public void findByLanguageNameTest() 
	{
		String languageName="Hindi";
		Language language=new Language(4,languageName);
		when(repository.findByLanguageName(languageName)).thenReturn(language);
		assertEquals(language,service.findByLanguageName(languageName));
		
	}

	





}
