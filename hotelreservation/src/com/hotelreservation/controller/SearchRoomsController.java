package com.hotelreservation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotelreservation.forms.SearchRoomsForm;
import com.hotelreservation.models.Rooms;
import com.hotelreservation.service.RoomsService;
import com.hotelreservation.session.SessionAttributesBean;

@Controller
public class SearchRoomsController {

	@Autowired
	RoomsService roomService;
	
	@RequestMapping(value = "searchrooms.html", method = RequestMethod.GET)
	public String displaySearchRooms(HttpServletRequest request, @ModelAttribute("searchRoomForm") SearchRoomsForm searchRoomForm, Model model) {
		HttpSession session = request.getSession(false);
		SessionAttributesBean sab = null;
		if(session != null) {
			sab = (SessionAttributesBean)session.getAttribute("sessionAttributes");
		}
		if(sab == null || session == null) {
			return "login";
		}
		return "home";
	}
	
	@RequestMapping(value = "searchrooms.html", method = RequestMethod.POST)
	public String searchRooms(HttpServletRequest request, @ModelAttribute("searchRoomForm") SearchRoomsForm searchRoomForm, Model model) {
		HttpSession session = request.getSession(false);
		SessionAttributesBean sab = null;
		if(session != null) {
			sab = (SessionAttributesBean)session.getAttribute("sessionAttributes");
		}
		if(sab == null || session == null) {
			return "login";
		}
		if(searchRoomForm.getMode() != null && searchRoomForm.getMode().equals("search")) {
			List<Rooms> filteredRooms =  roomService.findRoomsByAvailableDate(searchRoomForm.getCheckInDate(), searchRoomForm.getCheckOutDate());
			if(filteredRooms != null && !filteredRooms.isEmpty()) {
				model.addAttribute("filteredRooms", filteredRooms);
				model.addAttribute("checkInDate", searchRoomForm.getCheckInDate());
				model.addAttribute("checkOutDate", searchRoomForm.getCheckOutDate());
			}
		}
		return "home";
	}
}
