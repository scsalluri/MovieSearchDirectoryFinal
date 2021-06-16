package com.moviesearch.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.moviesearch.model.Language;

	public interface LanguageRepository extends CrudRepository<Language, Integer> {

	public Language findByLanguageName(String LanguageName);
	public List<Language> findAll();
	}
