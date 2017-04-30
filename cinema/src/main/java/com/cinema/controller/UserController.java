package com.cinema.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.model.User;
import com.cinema.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
	public User editUserDetails(@RequestBody String details, @PathVariable("id") Long id) {
		return userService.editUserDetails(details, id);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> editUserDetails() {
		return userService.editUserDetails();
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		return userService.logoutPage(request, response);
	}
}
