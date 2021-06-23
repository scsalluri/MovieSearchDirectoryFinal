package com.moviesearch.controller;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import com.moviesearch.model.Award;
import com.moviesearch.model.Company;
import com.moviesearch.model.Genre;
import com.moviesearch.model.Language;
import com.moviesearch.model.User;
import com.moviesearch.service.AwardService;
import com.moviesearch.service.CompanyService;
import com.moviesearch.service.GenreService;
import com.moviesearch.service.LanguageService;
import com.moviesearch.service.UserService;

@SuppressWarnings("deprecation")
@CrossOrigin(origins = "http:localhost:3000")
@RestController
public class RestControl {
    @Autowired
    private UserService userService;

	@Autowired
	private LanguageService languageService;
	@Autowired
	private AwardService awardService;
	@Autowired
	private GenreService genreService;
	@Autowired
	private CompanyService companyService;
    public RestControl() {
        // TODO Auto-generated constructor stub
    }


    @PostMapping("/save-user")
    public String registration(@RequestBody User user) {
        System.out.println("hello");
        if (userService.findByUsername(user.getUsername()) != null) {
            		return "Username already exists....";
        }
        else if (userService.findByEmail(user.getEmail()) != null) {
            		return "Email already registered..";
        }

        else
        {
        	userService.saveMyUser(user);
        	
        	return "success";
        }
    }

    @PostMapping("/login-user")
    public String loginuser(@RequestBody User user,HttpSession session) {
       
          
       if (userService.findByUsernameAndPassword(user.getUsername(),
                user.getPassword()) != null) {
    	   
            User users = userService.findByUsername(user.getUsername());
          
            if (users.getRole() != 0) {
               
                session.setAttribute("username", user.getUsername());
                session.setAttribute("loggedout", "loggedin");
                
               return "Admin";
             
               
            } else {
            	session.setAttribute("username", user.getUsername());
                session.setAttribute("loggedout", "loggedin");
                return "registered";	
              
            }
		} 
			 else { 
			
			 return "error";
			
    }
}
    
    @PostMapping("/save_award")
	public String saveAward(@RequestBody Award award1)
	{
		String award= award1.getawardName();
	
		if(awardService.findByAwardName(award)!=null)
		{

			return "fail";
		}
		else
		{
			int s= 0;
			for(Award l:awardService.getAllAwards() )
			{
				s= l.getawardId();
			} 
			Award awd= new Award(s+1,award);
			awardService.saveAward(awd);
			return "success";
		}
		
	}


	@PostMapping("/save_genre")
	public String  saveGenre(@RequestBody Genre genre)
	{
		String gen= genre.getGenreName();
	
		if(genreService.findByGenreName(gen)!=null)
		{
			return "fail";
		}
		else
		{
			int s= 0;
			for(Genre l:genreService.getAllGenres() )
			{
				s= l.getGenreId();
			}
			Genre g= new Genre(s+1,gen);
			genreService.saveGenre(g);
			return "success";
		}
		
	}
	@PostMapping("/save_language")
	public String saveLanguage(@RequestBody Language language)
	{
		String lang= language.getlanguageName();
		

		if(languageService.findByLanguageName(lang)!=null)
		{
			return "fail";
		}
		else
		{
			int s=0;
			for(Language l:languageService.getAllLanguages() )
			{
				s= l.getlanguageId();
			}
			
			
			Language langu= new Language(s+1,lang);
			languageService.saveLanguage(langu);
			return "success";
			
		}
		
	}
	
	@PostMapping("/save_company")
	public String saveCompany(@RequestBody  Company company)
	{
		String comp=company.getCompanyName();

		if(companyService.findByCompanyName(comp)!=null)
		{
			return "fail";
		}
		else
		{
			int s=0;
			for(Company l:companyService.getAllCompanys() )
			{
				s= l.getCompanyId();
			}
			Company comps= new Company(s+1,comp);
			companyService.saveCompany(comps);
			return "success";
		}
	
	}


    
}