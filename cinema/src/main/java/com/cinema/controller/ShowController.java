package com.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.model.Show;
import com.cinema.repository.ShowRepository;

@RestController
public class ShowController {

	@Autowired
	private ShowRepository repo;

	@RequestMapping(value = "/shows", method = RequestMethod.GET)
	public List<Show> listShows() {
		return repo.findAll();
	}
}
