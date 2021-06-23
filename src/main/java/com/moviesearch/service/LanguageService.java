package com.moviesearch.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.moviesearch.model.Language;

import com.moviesearch.repository.LanguageRepository;
@Service
@Transactional
public class LanguageService {
	private final LanguageRepository languageRepository;
	public LanguageService (LanguageRepository languageRepository)
	{
		this.languageRepository=languageRepository;
	}
public Language findByLanguageName(String languageName)
{
	return languageRepository.findByLanguageName(languageName);
}
public List<Language> getAllLanguages() {
	return languageRepository.findAll();
}
public Language saveLanguage(Language lang) {
	return languageRepository.save(lang);
	
}


}
