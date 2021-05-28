package com.moviesearch.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;


import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.Validator;

import com.moviesearch.model.Movies;
import com.moviesearch.model.User;
import com.moviesearch.repository.MovieRepository;
import com.moviesearch.service.MovieService;
import com.moviesearch.service.UserService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class maincontroller {
	
	@Value("${upoadDir}")
	private String uploadFolder;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
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
private Movies movie;
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

@RequestMapping(value="/awardForm")
public String awardForm()
{
	return "awardForm";
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

@PostMapping("/save-movie")

public @ResponseBody ResponseEntity<?> addMovie( @RequestParam("movie_name") String movie_name,
		@RequestParam("release_date")String release_date,
		@RequestParam("runtime") int runtime,
		@RequestParam("tagline") String tagline,
		@RequestParam("plot") String plot,
		@RequestParam("trailer") String trailer,
	    @RequestParam("lang") String lang,
	    @RequestParam("company") String company,
	    @RequestParam("castnames") String castnames,  
		@RequestParam("category") String category,
		// @RequestParam("country") String country,
		 Model model,HttpServletRequest request,
		 final @RequestParam("image") MultipartFile file)
{
	/*
	 * System.out.print("hello"); StringBuilder fileNames = new StringBuilder();
	 * String filename=
	 * file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
	 * Path fileNameAndPath =Paths.get(uploadDirectory,filename); try {
	 * Files.write(fileNameAndPath, file.getBytes()); } catch (IOException e) {
	 * e.printStackTrace(); } System.out.print(filename);
	 * 
	 * System.out.print(movie_name); System.out.print(release_date);
	 */
	 
	 
	try {
		//String uploadDirectory = System.getProperty("user.dir") + uploadFolder;
		String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
		log.info("uploadDirectory:: " + uploadDirectory);
		String fileName = file.getOriginalFilename();
		String filePath = Paths.get(uploadDirectory, fileName).toString();
		log.info("FileName: " + file.getOriginalFilename());
		if (fileName == null || fileName.contains("..")) {
			model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
		//	return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
		}try {
			File dir = new File(uploadDirectory);
			if (!dir.exists()) {
				log.info("Folder Created");
				dir.mkdirs();
			}BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();
		} catch (Exception e) {
			log.info("in catch");
			e.printStackTrace();
		}
		byte[] imageData = file.getBytes();
		System.out.print(imageData);
		 java.sql.Date date= java.sql.Date.valueOf(release_date); 
		  Movies m= new Movies(movie_name,tagline,plot,imageData, date,runtime,trailer); 
		  movieService.saveMovie(m);
		return new ResponseEntity<>("Product Saved With File - " + fileName, HttpStatus.OK);
	}catch (Exception e) {
		e.printStackTrace();
		log.info("Exception: " + e);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
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




@RequestMapping("/nameSearch")
public ModelAndView nameSearch(@RequestParam("movname") String movieName,Model model)
{
	System.out.print("hello");
	ModelAndView mav = new ModelAndView("showresult"); 
	Movies movie=movieService.findByMovieName(movieName);
	   // must match the jsp page name which is being requested.
		/*
		 * java.sql.Date date= java.sql.Date.valueOf("1996-05-05"); Movies movie= new
		 * Movies("Raja hindustani","ganwar movie","stupid movie","bekr movie",date,180,
		 * "www.google.com") ;
		 */
	    mav.addObject("moviename",movie.getmovieName() );
	    return mav;
	 // 
		/*
		 * java.sql.Date date= java.sql.Date.valueOf("1996-05-05"); Movies movie= new
		 * Movies("Raja hindustani","ganwar movie","stupid movie","bekr movie",date,180,
		 * "www.google.com") ; ModelAndView modelAndView= new ModelAndView();
		 * model.addAttribute(movie); modelAndView.addObject("movie", movie);
		 * 
		 * return modelAndView;
		 */


}

}
