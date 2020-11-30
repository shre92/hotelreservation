package com.hotelreservation.service;

import java.util.List;

import com.hotelreservation.models.RoomTypes;

public interface RoomTypesService {
	RoomTypes addRoomTypes(RoomTypes rty);
	List<RoomTypes> getAllRoomTypes();
	RoomTypes getRoomTypes(Integer rtyId);
	void deleteRoomTypes(Integer rtyId);
}
