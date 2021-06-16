package com.moviesearch.repository;
import org.springframework.data.repository.CrudRepository;

import com.moviesearch.model.Category;

	public interface CategoryRepository extends CrudRepository<Category, Integer> {

	public Category findByCategoryName(String CategoryName);
	public Category findByCategoryId(int CategoryId);
	}
