package com.cinema.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import com.cinema.model.User;
import com.cinema.repository.UserRepository;
import com.cinema.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	/**
	 * Updates a specific user based on the given details and user identifier.
	 * 
	 * @param details
	 *            User details.
	 * @param id
	 *            User identifier.
	 * @return User data.
	 */
	public User editUserDetails(String details, Long id) {
		User user = userRepo.findOne(id);
		user.setUserDetails(details);

		return userRepo.save(user);
	};

	/**
	 * Retrieves a collection of all users.
	 * 
	 * @return Returns the collection of all users.
	 */
	public List<User> getUsers() {
		return userRepo.findAll();
	};

	/**
	 * Logs out the logged in user.
	 * 
	 * @param request
	 * @param response
	 * @return Returns a confirmation message.
	 */
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "logged out";
	};
}
