package com.cinema.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.model.User;

public interface UserService {
	User editUserDetails(String details, Long id);
	
	List<User> editUserDetails();
	
	String logoutPage(HttpServletRequest request, HttpServletResponse response);
}
