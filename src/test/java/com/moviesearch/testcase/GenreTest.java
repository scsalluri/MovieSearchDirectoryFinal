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

	import com.moviesearch.repository.GenreRepository;

	import com.moviesearch.model.Genre;

	import com.moviesearch.service.GenreService;




	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class GenreTest {

		@Autowired
		private GenreService service;

		@MockBean
		private GenreRepository repository;

		@Test
		public void getAllGenreTest() 
		{
			when(repository.findAll()).thenReturn(Stream.of(new Genre(2,"Horror"),new Genre(6,"Thriller")).collect(Collectors.toList()));
			assertEquals(2, service.getAllGenres().size());
		}

		
		@Test
		public void saveGenre() 
		{
			Genre genre = new Genre(3,"Crime");
			when(repository.save(genre)).thenReturn(genre);
			assertEquals(genre, service.saveGenre(genre));
		}
		
		
		@Test
		public void findByGenreNameTest() 
		{
			String genreName="Comedy";
			Genre genre=new Genre(1,genreName);
			when(repository.findByGenreName(genreName)).thenReturn(genre);
			assertEquals(genre,service.findByGenreName(genreName));
			
		}

		


	}




