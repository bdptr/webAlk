package com.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.model.Show;
import com.cinema.repository.ShowRepository;
import com.cinema.service.ShowService;

@Service("showService")
public class ShowServiceImpl implements ShowService {
	
	@Autowired
	private ShowRepository showRepo;
	
	public List<Show> listShows() {
		return showRepo.findAll();
	}
}
