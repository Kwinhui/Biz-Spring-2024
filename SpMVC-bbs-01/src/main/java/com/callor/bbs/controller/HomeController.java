package com.callor.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class HomeController {
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		

		
		return "home";
	}
	
}
