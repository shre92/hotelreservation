package com.hotelreservation.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotelreservation.dao.RoomsDao;
import com.hotelreservation.models.Rooms;

@Repository
public class RoomsDaoImpl implements RoomsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public Rooms addRooms(Rooms rom) {
		Integer romId = (Integer)getSession().save(rom);
		return getRooms(romId);
	}

	public List<Rooms> getAllRooms() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Rooms> criteria = builder.createQuery(Rooms.class);
	    Root<Rooms> variableRoot = criteria.from(Rooms.class);
	    criteria.select(variableRoot);
	    List<Rooms> allRooms = getSession().createQuery(criteria).getResultList();
	    return allRooms;
	}

	public Rooms getRooms(Integer romId) {
		return (Rooms)getSession().get(Rooms.class, romId);
	}

	public void deleteRooms(Integer romId) {
		Rooms rom = (Rooms)getSession().get(Rooms.class,  romId);
		getSession().delete(rom);
	}
	@SuppressWarnings("unchecked")
	public List<Rooms> findRoomsByAvailableDate(Date checkInDate, Date checkOutDate) {
		String queryString = "FROM Rooms r WHERE r.romAvailableDate >= '" + checkInDate + "' AND r.romAvailableDate < '" + checkOutDate + "'";
		queryString = queryString + "AND r.romIsBooked IS NULL";
		Query query = getSession().createQuery(queryString);
		List<Rooms> result = query.getResultList();
		return result;
	}
	
	public void updateRooms(Rooms rom) {
		getSession().update(rom);
	}
	
	

}
