package com.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.dto.UserDto;
import com.cinema.model.User;
import com.cinema.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	private ModelMapper modelMapper = new ModelMapper();

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User editUserDetails(@RequestBody UserDto userDto) {
		return userService.editUserDetails(userDto.getUserDetails(), userDto.getId());
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserDto> editUserDetails() {
		List<User> users = userService.getUsers();
		return users.stream().map(user -> convertUserToUserDto(user)).collect(Collectors.toList());
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		return userService.logoutPage(request, response);
	}

	@RequestMapping(value = "/users/customers", method = RequestMethod.GET)
	public List<UserDto> getUsersWithCustomerRole() {
		List<User> users = userService.getUsersWithCustomerRole();
		return users.stream().map(user -> convertUserToUserDto(user)).collect(Collectors.toList());
	}

	private UserDto convertUserToUserDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}
}
