package com.hotelreservation.dao;

import java.util.List;

import com.hotelreservation.models.RoomBookings;

public interface RoomBookingsDao {
	RoomBookings addRoomBookings(RoomBookings rbo);
	List<RoomBookings> getAllRoomBookings();
	RoomBookings getRoomBookings(Integer rboId);
	void deleteRoomBookings(Integer rboId);
	List<RoomBookings> findRoomBookingsByRboBookingDoneBy(String rboBookingDoneBy);
}
