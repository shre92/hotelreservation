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

import com.hotelreservation.dao.UsersDao;
import com.hotelreservation.models.Users;

@Repository
public class UsersDaoImpl implements UsersDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Users addUsers(Users user) {
		String useUsername = (String)getSession().save(user);
		return getUsers(useUsername);
	}

	public List<Users> getAllUsers() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Users> criteria = builder.createQuery(Users.class);
	    Root<Users> variableRoot = criteria.from(Users.class);
	    criteria.select(variableRoot);
	    List<Users> allUsers = getSession().createQuery(criteria).getResultList();
	    return allUsers;
	}

	public Users getUsers(String useUsername) {
		return (Users)getSession().get(Users.class, useUsername);
	}

	public void deleteUsers(String useUsername) {
		Users user = (Users)getSession().get(Users.class,  useUsername);
		getSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	public Users findUsersByUsernameAndPassword(String useUsername, String usePassword) {
		String queryString = "FROM Users WHERE useUsername = '" + useUsername + "' AND usePassword = '" + usePassword + "'";
		Query query = getSession().createQuery(queryString);
		List<Users> result = query.getResultList();
		if(result != null && !result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

}
