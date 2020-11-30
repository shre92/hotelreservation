package com.hotelreservation.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelreservation.dao.RoomTypesDao;
import com.hotelreservation.models.RoomTypes;
import com.hotelreservation.service.RoomTypesService;

@Service
@Transactional
public class RoomTypesServiceImpl implements RoomTypesService{

	@Autowired
	RoomTypesDao roomTypesDao;
	
	public RoomTypes addRoomTypes(RoomTypes rty) {
		return roomTypesDao.addRoomTypes(rty);
	}

	public List<RoomTypes> getAllRoomTypes() {
		return roomTypesDao.getAllRoomTypes();
	}

	public RoomTypes getRoomTypes(Integer rtyId) {
		return roomTypesDao.getRoomTypes(rtyId);
	}

	public void deleteRoomTypes(Integer rtyId) {
		roomTypesDao.deleteRoomTypes(rtyId);
	}

}
