package com.moviesearch.service;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.moviesearch.model.Award;
import com.moviesearch.model.Category;
import com.moviesearch.repository.CategoryRepository;



@Service
@Transactional
public class CategoryService {
	private final CategoryRepository categoryRepository;
	public CategoryService (CategoryRepository categoryRepository)
	{
		this.categoryRepository=categoryRepository;
	}
public Category findByCategoryName(String CategoryName)
{
	return categoryRepository.findByCategoryName(CategoryName);
}

public Category findByCategoryId(int CategoryId)
{
	return categoryRepository.findByCategoryId(CategoryId);
}

public List <Category> getAllCategorys() {
	return (List<Category>) categoryRepository.findAll();
}
public Category saveCategory(Category category) {
	return categoryRepository.save(category);
	
}


}
