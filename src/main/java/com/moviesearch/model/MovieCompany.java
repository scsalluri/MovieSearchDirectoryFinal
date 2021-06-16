package com.moviesearch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="movie_company")
public class MovieCompany {
	@Id
	private int serialNo;
	private int MovieId;
	private int companyId;
	public MovieCompany(int serialNo,int movieId, int companyId) {
		super();
		this.serialNo=serialNo;
		this.MovieId = movieId;
		this.companyId = companyId;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public MovieCompany() {
		super();
	}
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getMovieId() {
		return MovieId;
	}
	public void setMovieId(int movieId) {
		this.MovieId = movieId;
	}

	
}
