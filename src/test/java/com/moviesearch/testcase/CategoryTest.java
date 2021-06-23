package com.moviesearch.testcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.moviesearch.repository.CategoryRepository;

import com.moviesearch.model.Category;

import com.moviesearch.service.CategoryService;




@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTest {

	@Autowired
	private CategoryService service;

	@MockBean
	private CategoryRepository repository;

	@Test
	public void getAllCategoryTest() 
	{
		when(repository.findAll()).thenReturn(Stream.of(new Category(2,"Best actor"),new Category(6,"Best actor in supportive role")).collect(Collectors.toList()));
		assertEquals(2, service.getAllCategorys().size());
	}

	
	@Test
	public void saveCategory() 
	{
		Category category = new Category(3,"Best actress");
		when(repository.save(category)).thenReturn(category);
		assertEquals(category, service.saveCategory(category));
	}
	
	@Test
	public void findByCategoryIdTest() 
	{
		int cid=1;
		Category Category=new Category(cid,"Best Story");
		when(repository.findByCategoryId(cid)).thenReturn(Category);
		assertEquals(Category,service.findByCategoryId(cid));
		
	}
	
	@Test
	public void findByCategoryNameTest() 
	{
		String CategoryName="Best Critics";
		Category Category=new Category(4,CategoryName);
		when(repository.findByCategoryName(CategoryName)).thenReturn(Category);
		assertEquals(Category,service.findByCategoryName(CategoryName));
		
	}

	


}

