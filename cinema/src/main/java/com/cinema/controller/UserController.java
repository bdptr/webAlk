package com.cinema.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.model.User;
import com.cinema.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repo;
	
	@RequestMapping(value="/user/edit/{id}", method=RequestMethod.POST)
	public User editUserDetails(@RequestBody String details, @PathVariable("id") Long id)
	{
		User user = repo.findOne(id);
		user.setUserDetails(details);
		
		return repo.save(user);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> editUserDetails()
	{	
		return repo.findAll();
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "logged out yay";
	}
}
