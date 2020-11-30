package com.hotelreservation.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelreservation.dao.RoomBookingsDao;
import com.hotelreservation.models.RoomBookings;
import com.hotelreservation.service.RoomBookingsService;

@Service
@Transactional
public class RoomBookingsServiceImpl implements RoomBookingsService{

	@Autowired
	RoomBookingsDao rboDao;
	
	public RoomBookings addRoomBookings(RoomBookings rbo) {
		return rboDao.addRoomBookings(rbo);
	}

	public List<RoomBookings> getAllRoomBookings() {
		return rboDao.getAllRoomBookings();
	}

	public RoomBookings getRoomBookings(Integer rboId) {
		return rboDao.getRoomBookings(rboId);
	}

	public void deleteRoomBookings(Integer rboId) {
		rboDao.deleteRoomBookings(rboId);
	}

	public List<RoomBookings> findRoomBookingsByRboBookingDoneBy(String rboBookingDoneBy) {
		return rboDao.findRoomBookingsByRboBookingDoneBy(rboBookingDoneBy);
	}

}
