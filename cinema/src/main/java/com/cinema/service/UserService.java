package com.cinema.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.model.User;

public interface UserService {

	/**
	 * Updates a specific user based on the given details and user identifier.
	 * 
	 * @param details
	 *            User details.
	 * @param id
	 *            User identifier.
	 * @return User data.
	 */
	User editUserDetails(String details, Long id);

	/**
	 * Retrieves a list of all users.
	 * 
	 * @return Returns the list of all users.
	 */
	List<User> getUsers();

	/**
	 * Logs out the logged in user.
	 * 
	 * @param request
	 * @param response
	 * @return Returns a confirmation message.
	 */
	String logoutPage(HttpServletRequest request, HttpServletResponse response);
}
