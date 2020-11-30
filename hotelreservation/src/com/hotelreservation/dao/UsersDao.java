package com.hotelreservation.dao;

import java.util.List;

import com.hotelreservation.models.Users;

public interface UsersDao {
	Users addUsers(Users user);
	List<Users> getAllUsers();
	Users getUsers(String useUsername);
	void deleteUsers(String useUsername);
	Users findUsersByUsernameAndPassword(String useUsername, String usePassword);
}
