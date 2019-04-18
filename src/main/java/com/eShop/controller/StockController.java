package com.eShop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eShop.model.Stock;
import com.eShop.service.StockService;

@Controller
public class StockController {
	
	@Autowired
	StockService stockService;
	
	
	@GetMapping("/addstockform")
	public String stockForm(Model model) {
		model.addAttribute("stock", new Stock());
		return "stock/add";
	}
	
	@PostMapping("/addStock")
	public String addStock(@Valid Stock stock, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			return "failure.html";
		}
		stockService.createStock(stock);		
		return "redirect:admin";

	}
	
	@RequestMapping(value = "/user/search", method = RequestMethod.GET)
	public ModelAndView searchStock(@RequestParam(defaultValue="") String title) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("title", "Search Products");
		modelAndView.addObject("products", stockService.findByTitle(title));
		modelAndView.setViewName("stock/search"); 
		return modelAndView;
	}



}
