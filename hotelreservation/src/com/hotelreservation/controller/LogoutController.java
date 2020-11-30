package com.hotelreservation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

	
	@RequestMapping(value = "logout.html", method = RequestMethod.GET)
	public String logoutTheUser(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.removeAttribute("sessionAttributes");
			session.invalidate();
			
		}
		return "redirect:login.html";
	}
}
