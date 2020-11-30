package com.hotelreservation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hotelreservation.forms.RegistrationForm;
import com.hotelreservation.models.Users;
import com.hotelreservation.service.UsersService;

@Controller
public class RegistrationController {
	
	@Autowired
	UsersService userService;
	
	@RequestMapping(value = "registeruser.html", method = RequestMethod.POST)
	public String registerUser(RedirectAttributes redirectAttributes, HttpServletRequest request, @ModelAttribute("registrationForm") RegistrationForm regForm,Model model) {
		Users users = new Users();
		users.setUseUsername(regForm.getUseUsername());
		users.setUseFirstname(regForm.getUseFirstname());
		users.setUseLastname(regForm.getUseLastname());
		users.setUseEmail(regForm.getUseEmail());
		users.setUseMobile(regForm.getUseMobile());
		users.setUsePassword(regForm.getUsePassword());
		users.setUseIsAdmin(0);
		
		userService.addUsers(users);
		
		redirectAttributes.addFlashAttribute("message", "Registration Successful");
		return "redirect:login.html";
	}
}
