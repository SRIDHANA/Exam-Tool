package com.sridhana.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.sridhana.model.User;
import com.sridhana.model.Usertype;
import com.sridhana.service.LoginService;

@Controller
public class LoginController {

	int TIMELIMIT ;
	boolean start_test;
	int minutes;
	int seconds ;
    String timecounter;

    	@Autowired
    	private LoginService loginService;	

    	@Autowired
    	@Qualifier(value = "loginService")
    	public void setLoginService(LoginService loginService) {
    		this.loginService = loginService;
    	}
    
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView redirectIndexPage(ModelAndView model) {
	
		//original code
		
		try
		{
		User user= new User();
		model.addObject("user", user);
	
		model.setViewName("Login");

		}catch (Exception e) {
		}
		return model;
	
		
	}

	
	@RequestMapping(value = "/loginprocess",method=RequestMethod.POST)
	public ModelAndView validateLogin(@ModelAttribute User user,HttpServletRequest request,HttpServletResponse response, BindingResult result,ModelAndView model)
	{		
		 HttpSession session = request.getSession();
		session.setAttribute("User",user);
		System.out.println("username entered :" + user.getUsername());
		System.out.println("password entered :" +user.getPassword());				
		try
		{
		User userfound = loginService.validateUser(user);
		System.out.println("lastname got :" + userfound.getLastname());
		System.out.println("email got :" +userfound.getEmail());				
		
		if(userfound.getFirstname() != null)
		{
			switch (userfound.getUsertype())
			{
				case "ADMIN":
				model.addObject("user", userfound);
				model.setViewName("/Admin/AdminHomePage");
				    break;
				case "FACULTY":
					model.addObject("user", userfound);
					model.setViewName("/Faculty/FacultyHomePage");
					break;
				case "STUDENT":
					model.addObject("user", userfound);
					model.setViewName("/Student/StudentHomePage");
					break;	
			}
		}
		else{
			if(userfound.getUsername() != null)
			{
			model.addObject("error", "Check Password Entered");
			model.setViewName("Login");
			}
			else
			{
				model.addObject("error", "Check Username /Password Entered");
				model.setViewName("Login");
					
			}
		}
		}catch (Exception e) {
			model.addObject("exception", e);
			model.setViewName("ErrorPage");
		}
		
		return model;
	}		
		
		
	
	@RequestMapping(value = "/end", method = RequestMethod.POST)
	public  String 	endTest(HttpServletRequest request,
			HttpServletResponse response
					 ,RedirectAttributes redirectAttributes) 
					 throws IllegalStateException, IOException 
{
		return "result";
}
	
	@RequestMapping(value = "/exam", method = RequestMethod.POST)
	public  
	String 
	questionProcessor(HttpServletRequest request,
			HttpServletResponse response
					 ,RedirectAttributes redirectAttributes) 
					 throws IllegalStateException, IOException 
{
		String action=request.getParameter("action");
		System.out.println(request.getParameter("minute"));		
		
		redirectAttributes.addAttribute("timer", timecounter);
		if("previous".equals(action)){
			System.out.println("You clicked Previous Button");
		}
		return "redirect:/";				
}	
}