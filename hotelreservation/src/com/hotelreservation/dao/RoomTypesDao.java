package com.hotelreservation.dao;

import java.util.List;

import com.hotelreservation.models.RoomTypes;

public interface RoomTypesDao {
	RoomTypes addRoomTypes(RoomTypes rty);
	List<RoomTypes> getAllRoomTypes();
	RoomTypes getRoomTypes(Integer rtyId);
	void deleteRoomTypes(Integer rtyId);
}
