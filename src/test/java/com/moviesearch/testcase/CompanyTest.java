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

	import com.moviesearch.repository.CompanyRepository;

	import com.moviesearch.model.Company;

	import com.moviesearch.service.CompanyService;




	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class CompanyTest {

		@Autowired
		private CompanyService service;

		@MockBean
		private CompanyRepository repository;

		@Test
		public void getAllCompanyTest() 
		{
			when(repository.findAll()).thenReturn(Stream.of(new Company(2,"T-Series"),new Company(6,"Maddock Films")).collect(Collectors.toList()));
			assertEquals(2, service.getAllCompanys().size());
		}

		
		@Test
		public void saveCompany() 
		{
			Company company = new Company(3,"Amir Khan");
			when(repository.save(company)).thenReturn(company);
			assertEquals(company, service.saveCompany(company));
		}
		
		
		
		@Test
		public void findByCompanyNameTest() 
		{
			String companyName="SRK Films";
			Company company=new Company(4,companyName);
			when(repository.findByCompanyName(companyName)).thenReturn(company);
			assertEquals(company,service.findByCompanyName(companyName));
			
		}

		





}
