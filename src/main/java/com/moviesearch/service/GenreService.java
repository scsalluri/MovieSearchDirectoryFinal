package com.moviesearch.service;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.moviesearch.model.Genre;
import com.moviesearch.repository.GenreRepository;



@Service
@Transactional
public class GenreService {
	private final GenreRepository genreRepository;
	public GenreService (GenreRepository genreRepository)
	{
		this.genreRepository=genreRepository;
	}
public Genre findByGenreName(String GenreName)
{
	return genreRepository.findByGenreName(GenreName);
}
public List <Genre> getAllGenres() {
	return (List<Genre>) genreRepository.findAll();
}
public void saveGenre(Genre gen) {
	genreRepository.save(gen);
	// TODO Auto-generated method stub
	
}
}
