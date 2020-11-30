package com.hotelreservation.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotelreservation.dao.RoomTypesDao;
import com.hotelreservation.models.RoomTypes;

@Repository
public class RoomTypesDaoImpl implements RoomTypesDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public RoomTypes addRoomTypes(RoomTypes rty) {
		Integer rtyId = (Integer)getSession().save(rty);
		return getRoomTypes(rtyId);
	}

	public List<RoomTypes> getAllRoomTypes() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<RoomTypes> criteria = builder.createQuery(RoomTypes.class);
	    Root<RoomTypes> variableRoot = criteria.from(RoomTypes.class);
	    criteria.select(variableRoot);
	    List<RoomTypes> allRoomTypes = getSession().createQuery(criteria).getResultList();
	    return allRoomTypes;
	}

	public RoomTypes getRoomTypes(Integer rtyId) {
		return (RoomTypes)getSession().get(RoomTypes.class, rtyId);
	}

	public void deleteRoomTypes(Integer rtyId) {
		RoomTypes rty = (RoomTypes)getSession().get(RoomTypes.class,  rtyId);
		getSession().delete(rty);
	}

}
