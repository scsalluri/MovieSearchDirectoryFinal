package com.moviesearch;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.moviesearch.controller.maincontroller;

@SpringBootApplication
public class MovieSearchDirecory1Application {

	public static void main(String[] args) {
		new File(maincontroller.uploadDirectory).mkdir();
		SpringApplication.run(MovieSearchDirecory1Application.class, args);
	}

}
