package com.hotelreservation.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotelreservation.dao.RoomBookingsDao;
import com.hotelreservation.models.RoomBookings;
import com.hotelreservation.models.Rooms;

@Repository
public class RoomBookingsDaoImpl implements RoomBookingsDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public RoomBookings addRoomBookings(RoomBookings rbo) {
		Integer rboId = (Integer)getSession().save(rbo);
		return getRoomBookings(rboId);
	}

	public List<RoomBookings> getAllRoomBookings() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<RoomBookings> criteria = builder.createQuery(RoomBookings.class);
	    Root<RoomBookings> variableRoot = criteria.from(RoomBookings.class);
	    criteria.select(variableRoot);
	    List<RoomBookings> allRoomBookings = getSession().createQuery(criteria).getResultList();
	    return allRoomBookings;
	}

	public RoomBookings getRoomBookings(Integer rboId) {
		return (RoomBookings)getSession().get(RoomBookings.class, rboId);
	}

	public void deleteRoomBookings(Integer rboId) {
		RoomBookings rbo = (RoomBookings)getSession().get(RoomBookings.class,  rboId);
		getSession().delete(rbo);
	}
	
	@SuppressWarnings("unchecked")
	public List<RoomBookings> findRoomBookingsByRboBookingDoneBy(String rboBookingDoneBy) {
		String queryString = "FROM RoomBookings r";
		if(rboBookingDoneBy != null && !rboBookingDoneBy.isEmpty()) {
			queryString = queryString + " where r.rboBookingDoneBy = '" + rboBookingDoneBy + "'";
		}
		Query query = getSession().createQuery(queryString);
		List<RoomBookings> result = query.getResultList();
		return result;
	}

}
