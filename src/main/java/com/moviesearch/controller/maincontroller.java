package com.moviesearch.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moviesearch.model.User;
import com.moviesearch.service.UserService;

@Controller
public class maincontroller {
@Autowired
private UserService userService;
@RequestMapping("/")
public String home()
{	
	return "main";
}
@RequestMapping(value="/login")
public String loginPage()
{
	return "login_page";
}
@RequestMapping(value="/register")
public String loginPage2()
{
	return "signup";
	
	}
@PostMapping("/save-user")
public String registration(@ModelAttribute User user ,BindingResult bindingResult, HttpServletRequest request)
{
	userService.saveMyUser(user);
	return "login_page";
}




@RequestMapping("/login-user")
public String loginuser(@ModelAttribute User user,HttpServletRequest request)
{

	if(userService.findByUsernameAndPassword(user.getUsername(),user.getPassword())!=null)
	{
		 if(user.getUsername().equals("Admin"))
			 return "adminmain";
		 else
			 return "normalpage";
	}
	else
	{
		request.setAttribute("error", "Invaid Username or Password");
		return "login_page";
	}

}


}
