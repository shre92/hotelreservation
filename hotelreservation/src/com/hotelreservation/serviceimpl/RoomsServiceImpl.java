package com.hotelreservation.serviceimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelreservation.dao.RoomsDao;
import com.hotelreservation.models.Rooms;
import com.hotelreservation.service.RoomsService;

@Service
@Transactional
public class RoomsServiceImpl implements RoomsService{

	@Autowired
	RoomsDao roomsDao;
	
	public Rooms addRooms(Rooms rom) {
		return roomsDao.addRooms(rom);
	}

	public List<Rooms> getAllRooms() {
		return roomsDao.getAllRooms();
	}

	public Rooms getRooms(Integer romId) {
		return roomsDao.getRooms(romId);
	}

	public void deleteRooms(Integer romId) {
		roomsDao.deleteRooms(romId);
	}

	public List<Rooms> findRoomsByAvailableDate(Date checkInDate, Date checkOutDate) {
		return roomsDao.findRoomsByAvailableDate(checkInDate, checkOutDate);
	}

	public void updateRooms(Rooms rom) {
		roomsDao.updateRooms(rom);
	}
	
}
