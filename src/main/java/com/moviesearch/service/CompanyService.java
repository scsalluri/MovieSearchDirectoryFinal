package com.moviesearch.service;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.moviesearch.model.Company;
import com.moviesearch.repository.CompanyRepository;



@Service
@Transactional
public class CompanyService {
	private final CompanyRepository companyRepository;
	public CompanyService (CompanyRepository companyRepository)
	{
		this.companyRepository=companyRepository;
	}
public Company findByCompanyName(String companyName)
{
	return companyRepository.findByCompanyName(companyName);
}
public List <Company> getAllCompanys() {
	return (List<Company>) companyRepository.findAll();
}
public Company saveCompany(Company c)
{
	return companyRepository.save(c);
}

}
