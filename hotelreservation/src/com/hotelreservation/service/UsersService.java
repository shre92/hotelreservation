package com.hotelreservation.service;

import java.util.List;

import com.hotelreservation.models.Users;

public interface UsersService {
	Users addUsers(Users user);
	List<Users> getAllUsers();
	Users getUsers(String useUsername);
	void deleteUsers(String useUsername);
	Users findUserByUsernameAndPassword(String useUsername, String usePassword);
}
