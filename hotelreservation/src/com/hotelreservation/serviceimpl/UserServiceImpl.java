package com.hotelreservation.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelreservation.dao.UsersDao;
import com.hotelreservation.models.Users;
import com.hotelreservation.service.UsersService;

@Service
@Transactional
public class UserServiceImpl implements UsersService{

	@Autowired
	UsersDao userDao;
	
	public Users addUsers(Users user) {
		return userDao.addUsers(user);
	}

	public List<Users> getAllUsers() {
		return userDao.getAllUsers();
	}

	public Users getUsers(String useUsername) {
		return userDao.getUsers(useUsername);
	}

	public void deleteUsers(String useUsername) {
		userDao.deleteUsers(useUsername);
	}
	
	public Users findUserByUsernameAndPassword(String useUsername, String usePassword) {
		return userDao.findUsersByUsernameAndPassword(useUsername, usePassword);
		
	}

}
