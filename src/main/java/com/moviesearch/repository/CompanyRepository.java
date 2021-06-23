package com.moviesearch.repository;
import org.springframework.data.repository.CrudRepository;

import com.moviesearch.model.Company;

	public interface CompanyRepository extends CrudRepository<Company, Integer> {

	public Company findByCompanyName(String CompanyName);
}
