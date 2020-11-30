package com.hotelreservation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotelreservation.forms.LoginForm;
import com.hotelreservation.models.RoomBookings;
import com.hotelreservation.models.Users;
import com.hotelreservation.service.RoomBookingsService;
import com.hotelreservation.service.UsersService;
import com.hotelreservation.session.SessionAttributesBean;

@Controller
public class LoginController {
	
	@Autowired
	UsersService userService;
	
	@Autowired
	RoomBookingsService rboService;
	
	@RequestMapping(value = "home.html", method = {RequestMethod.POST,RequestMethod.GET})
	public String validateLogin(@ModelAttribute("loginForm") LoginForm login, Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		SessionAttributesBean sab = null;
		if(session != null) {
			sab = (SessionAttributesBean)session.getAttribute("sessionAttributes");
		}
		if(sab != null) {
			if(sab.getUsrType() != null && sab.getUsrType().equals("admin")) {
				List<RoomBookings> rboList = rboService.findRoomBookingsByRboBookingDoneBy(null);
				model.addAttribute("bookings", rboList);
			}
			return "home";
		}
		Users user = userService.findUserByUsernameAndPassword(login.getUseUsername(), login.getUsePassword());
		if(user != null) {
			setSession(user, request);
			model.addAttribute("message", "Welcome to Hotel Reservation");
			if(user.getUseIsAdmin() != null && user.getUseIsAdmin().intValue() == 1) {
				List<RoomBookings> rboList = rboService.findRoomBookingsByRboBookingDoneBy(null);
				model.addAttribute("bookings", rboList);
			}
			return "home";
		}
		model.addAttribute("message", "Invalid Username or password");
		return "login";
	}
	
	
	 private void setSession(Users users, HttpServletRequest request) { 
		 HttpSession session = request.getSession(); 
		 SessionAttributesBean sb = new SessionAttributesBean();
		 sb.setSessionId(session.getId());
		 sb.setUsrUserName(users.getUseUsername());
		 if(users.getUseIsAdmin() != null && users.getUseIsAdmin().intValue() == 1) {
			 sb.setUsrType("admin");
		 }
		 else {
			 sb.setUsrType("visitor");
		 }
		 session.setAttribute("sessionAttributes", sb); 
	 }
	 
}
