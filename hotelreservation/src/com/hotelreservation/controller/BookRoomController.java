package com.hotelreservation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hotelreservation.forms.BookRoomForm;
import com.hotelreservation.models.RoomBookings;
import com.hotelreservation.models.Rooms;
import com.hotelreservation.service.RoomBookingsService;
import com.hotelreservation.service.RoomsService;
import com.hotelreservation.session.SessionAttributesBean;

@Controller
public class BookRoomController {
	
	@Autowired
	RoomsService roomService;
	
	@Autowired
	RoomBookingsService rboService;
	
	@RequestMapping(value = "displaybookroom.html")
	public String displayBookRoom(HttpServletRequest request,  Model model) {
		HttpSession session = request.getSession(false);
		SessionAttributesBean sab = null;
		if(session != null) {
			sab = (SessionAttributesBean)session.getAttribute("sessionAttributes");
		}
		if(sab == null || session == null) {
			return "login";
		}
		
		String romId = request.getParameter("romId");
		if(romId != null && !romId.isEmpty()) {
			Rooms room = roomService.getRooms(Integer.valueOf(romId));
			if(room != null) {
				model.addAttribute("room", room);
			}
		}
		return "bookroom";
	}
	
	@RequestMapping(value = "bookroom.html")
	public String bookRoom(HttpServletRequest request,  RedirectAttributes redirectAttributes, @ModelAttribute("bookRoomForm") BookRoomForm brForm) {
		HttpSession session = request.getSession(false);
		SessionAttributesBean sab = null;
		if(session != null) {
			sab = (SessionAttributesBean)session.getAttribute("sessionAttributes");
		}
		if(sab == null || session == null) {
			return "login";
		}
		
		RoomBookings rbo = new RoomBookings();
		rbo.setRboNoOfGuests(brForm.getNoOfGuests());
		rbo.setRboCheckinDate(brForm.getCheckInDateForBooking());
		rbo.setRboCheckoutDate(brForm.getCheckOutDateForBooking());
		rbo.setRboBookingDoneBy(sab.getUsrUserName());
		rbo.setRboRomId(brForm.getRomId());
		rboService.addRoomBookings(rbo);
		
		Rooms rom = roomService.getRooms(brForm.getRomId());
		rom.setRomIsBooked(1);
		roomService.updateRooms(rom);
		
		redirectAttributes.addFlashAttribute("message", "Room Booked Successfully");
		return "redirect:searchrooms.html";
	}
	
	@RequestMapping(value = "mybookings.html")
	public String myBookings(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		SessionAttributesBean sab = null;
		if(session != null) {
			sab = (SessionAttributesBean)session.getAttribute("sessionAttributes");
		}
		if(sab == null || session == null) {
			return "login";
		}
		
		List<RoomBookings> rboList = rboService.findRoomBookingsByRboBookingDoneBy(sab.getUsrUserName());
		model.addAttribute("mybookings", rboList);
		
		return "mybookings";
		
	}
	
}
