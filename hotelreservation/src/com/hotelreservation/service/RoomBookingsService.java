package com.hotelreservation.service;

import java.util.List;

import com.hotelreservation.models.RoomBookings;

public interface RoomBookingsService {
	RoomBookings addRoomBookings(RoomBookings rbo);
	List<RoomBookings> getAllRoomBookings();
	RoomBookings getRoomBookings(Integer rboId);
	void deleteRoomBookings(Integer rboId);
	List<RoomBookings> findRoomBookingsByRboBookingDoneBy(String rboBookingDoneBy);
}
