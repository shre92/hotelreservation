package com.hotelreservation.dao;

import java.sql.Date;
import java.util.List;

import com.hotelreservation.models.Rooms;

public interface RoomsDao {
	Rooms addRooms(Rooms rom);
	List<Rooms> getAllRooms();
	Rooms getRooms(Integer romId);
	void deleteRooms(Integer romId);
	List<Rooms> findRoomsByAvailableDate(Date checkInDate, Date checkOutDate);
	void updateRooms(Rooms rom);
}
