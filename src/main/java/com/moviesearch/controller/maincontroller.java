package com.moviesearch.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.Validator;
import com.moviesearch.model.User;
import com.moviesearch.service.UserService;

@Controller
public class maincontroller {
	
	@Autowired
	private Validator validator;
	@Autowired
	public maincontroller( Validator validator) {
		System.out.println("in parametized constr of controller with validator");
		this.validator = validator;
	}	
	
@Autowired
private UserService userService;
@Autowired
private User user;
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
	return "login_page";
}


@RequestMapping("/login-user")
public String loginuser(@Valid @ModelAttribute User user,Errors error,BindingResult result, HttpServletRequest request)
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
