package com.hotelreservation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hotelreservation.models.RoomTypes;
import com.hotelreservation.service.RoomTypesService;
import com.hotelreservation.session.SessionAttributesBean;

@Controller
public class RoomTypesController {
	@Autowired
	RoomTypesService rtyService;
	
	@RequestMapping(value = "roomtypes.html")
	public String getAllRoomTypes(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		SessionAttributesBean sab = null;
		if(session != null) {
			sab = (SessionAttributesBean)session.getAttribute("sessionAttributes");
		}
		if(sab == null || session == null) {
			return "login";
		}
		List<RoomTypes> rooms = rtyService.getAllRoomTypes();
		if(rooms != null && !rooms.isEmpty()) {
			model.addAttribute("rooms",rooms);
		}
		return "roomtypes";
	}
	
	@RequestMapping(value = "addroomtype.html", method=RequestMethod.POST)
	public String addRoom(HttpServletRequest request,RedirectAttributes redirectAttributes) {
		HttpSession session = request.getSession(false);
		SessionAttributesBean sab = null;
		if(session != null) {
			sab = (SessionAttributesBean)session.getAttribute("sessionAttributes");
		}
		if(sab == null || session == null) {
			return "login";
		}
		
		String roomTypeName = request.getParameter("roomType");
		RoomTypes roomType = new RoomTypes();
		roomType.setRtyName(roomTypeName);
		rtyService.addRoomTypes(roomType);
		redirectAttributes.addFlashAttribute("message", "Room Type Added Successfully");
		return "redirect:roomtypes.html";
	}
}
