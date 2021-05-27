package com.moviesearch.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;


import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.Validator;

import com.moviesearch.model.Movie;
import com.moviesearch.model.User;
import com.moviesearch.repository.MovieRepository;
import com.moviesearch.service.MovieService;
import com.moviesearch.service.UserService;

@Controller
public class maincontroller {
	
	@Autowired
	private Validator validator;
	@Autowired
	public maincontroller( Validator validator) {
		this.validator = validator;
	}	
	
@Autowired
private UserService userService;
@Autowired
private MovieService movieService;
@Autowired
private User user;

@Autowired
private Movie movie;
public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/webapp/imagedata";
@RequestMapping("/")
public String home()
{	
	return "mainPage";
}
@RequestMapping("movieForm")
public String movieForm(Model model)
{	
	model.addAttribute("movie",movie);
	return "movieForm";
}

@RequestMapping(value="/login")
public String loginPage()
{
	return "loginPage";
}
@RequestMapping(value="/register")
public String regisgterPage(Model model)
{
	model.addAttribute("user",user);
	return "signup";
	
	}
@PostMapping("/save-user")
public String registration( @ModelAttribute("user") @Valid User user ,Errors error, BindingResult bindingResult,RedirectAttributes rs)
{
	
	if(userService.findByUsername(user.getUsername())!=null)
	{
		bindingResult.addError(new FieldError("user", "username","Username already exists...."));
	}
	if(userService.findByEmail(user.getEmail())!=null)
	{
		bindingResult.addError(new FieldError("user", "email","Email already exists.."));
	}
	if(error.hasErrors())
	{
		return "signup";
		
	}
	rs.addFlashAttribute("message","Sucessfully Registration");
	userService.saveMyUser(user);
	return "loginPage";
}

@RequestMapping("/save-movie")

public String addMovie(
		/*
		 * @RequestParam("movie_name") String movie_name,@RequestParam("release_date")
		 * String release_date,@RequestParam("runtime") int
		 * runtime,@RequestParam("tagline") String tagline,@RequestParam("plot") String
		 * plot,@RequestParam("trailer") String trailer,
		 * 
		 * @RequestParam("lang") String lang,@RequestParam("company") String
		 * company,@RequestParam("castnames") String castnames,
		 * 
		 * @RequestParam("category") String category,
		 * 
		 * @RequestParam("country") String country,
		 */@RequestParam("img") MultipartFile file)
{
	System.out.print("hello");
	StringBuilder fileNames = new StringBuilder();
	String filename= file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
	Path fileNameAndPath =Paths.get(uploadDirectory,filename);
	try {
		Files.write(fileNameAndPath, file.getBytes());
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.print(filename);
	/*
	 * System.out.print(movie_name); System.out.print(release_date);
	 * 
	 * java.sql.Date date= java.sql.Date.valueOf(release_date); Movie m= new
	 * Movie(movie_name,tagline,plot,trailer, date,runtime,trailer); //
	 * movieService.saveMovie(m);
	 */	return "movie.getMovieNmae";
}


@RequestMapping("/login-user")
public String loginuser(@Valid @ModelAttribute User user,Errors error,BindingResult result, HttpServletRequest request)
{

if(userService.findByUsernameAndPassword(user.getUsername(),user.getPassword())!=null)
	{
	System.out.println(user.getRole());
		 if(user.getUsername().equals("Admin"))
			 return "adminPage";
		 else
			 return "registeredUser";
	}
	else
	{
		request.setAttribute("error", "Invaid Username or Password");
		return "loginPage";
	}
	
}


}
