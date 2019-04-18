package com.eShop.controller;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eShop.model.User;
import com.eShop.service.StockService;
import com.eShop.service.UserService;

@Controller
public class AuthenticationController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	StockService stockService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String redirect() {
		return "redirect:login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login"); // resources/template/login.html
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user); 
		modelAndView.setViewName("register"); // resources/template/register.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("title", "Home");
		modelAndView.addObject("products", stockService.findAll());
		modelAndView.setViewName("home"); 
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminHome() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("title", "Admin");
		modelAndView.addObject("products", stockService.findAll());
		modelAndView.setViewName("admin"); // resources/template/admin.html
		return modelAndView;
	}

	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		
		//check validation
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in the form");
			modelMap.addAttribute("bindingResult", bindingResult);
			
		}
	
		//if user already exists
		else if(userService.isUserAlreadyPresent(user)){
			modelAndView.addObject("successMessage", "This user already exists");
		}
		//save user
		else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been created");
			modelAndView.setViewName("home");
		}
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("register");
		
		return modelAndView;
		
		
	}
}
