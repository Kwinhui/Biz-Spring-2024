package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value="/user")
public class UserController {

	private final UserService userService;
	public UserController(UserService userService ) {
		this.userService = userService;
	}

	@RequestMapping(value="/get", method=RequestMethod.GET)
	public String getUser() {
		return null;
	}
	
}
