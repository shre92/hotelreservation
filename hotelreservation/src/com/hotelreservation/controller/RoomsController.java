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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hotelreservation.forms.AddRoomForm;
import com.hotelreservation.models.RoomTypes;
import com.hotelreservation.models.Rooms;
import com.hotelreservation.service.RoomTypesService;
import com.hotelreservation.service.RoomsService;
import com.hotelreservation.session.SessionAttributesBean;

@Controller
public class RoomsController {
	@Autowired
	RoomsService romService;
	
	@Autowired
	RoomTypesService rtyService;
	
	@RequestMapping(value = "rooms.html")
	public String getAllRooms(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		SessionAttributesBean sab = null;
		if(session != null) {
			sab = (SessionAttributesBean)session.getAttribute("sessionAttributes");
		}
		if(sab == null || session == null) {
			return "login";
		}
		List<Rooms> rooms = romService.getAllRooms();
		if(rooms != null && !rooms.isEmpty()) {
			model.addAttribute("rooms",rooms);
		}
		List<RoomTypes> roomTypes = rtyService.getAllRoomTypes();
		if(roomTypes != null && !roomTypes.isEmpty()) {
			model.addAttribute("roomTypes",roomTypes);
		}
		return "rooms";
	}
	
	@RequestMapping(value = "addroom.html", method=RequestMethod.POST)
	public String addRoom(HttpServletRequest request, @ModelAttribute("addRoomForm") AddRoomForm romForm, RedirectAttributes redirectAttributes) {
		HttpSession session = request.getSession(false);
		SessionAttributesBean sab = null;
		if(session != null) {
			sab = (SessionAttributesBean)session.getAttribute("sessionAttributes");
		}
		if(sab == null || session == null) {
			return "login";
		}
		Rooms room = new Rooms();
		room.setRomRtyId(romForm.getRoomType());
		room.setRomCapacity(romForm.getRoomCapacity());
		room.setRomAvailableDate(romForm.getRoomAvailableDate());
		romService.addRooms(room);
		redirectAttributes.addFlashAttribute("message", "Room Added Successfully");
		return "redirect:rooms.html";
	}
}
