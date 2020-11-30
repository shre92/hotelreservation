package com.hotelreservation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {
	@RequestMapping(value = "login.html", method = RequestMethod.GET)
	public String loginPage(HttpServletResponse response, HttpServletRequest request) {
		request.setAttribute("fromLogin", "true");
		return "login";
	}
	
	@RequestMapping(value = "useradd.html", method = RequestMethod.GET)
	public String registerPage(HttpServletResponse response, HttpServletRequest request) {
		request.setAttribute("fromRegistration", "true");
		return "register";
	}
}
