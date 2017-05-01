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

	/**
	 * Retrieves a collection of shows of a specific cinema based on a given
	 * cinema name.
	 * 
	 * @param cinemaName
	 *            Represents the cinema we want to filter the shows by.
	 * @return Returns the collection of shows of a specific cinema based on a
	 *         given cinema name.
	 */
	public List<Show> findShowByCinema(String cinemaName) {
		return showRepo.findShowByCinema(cinemaName);
	}

	/**
	 * Retrieves a collection of all shows.
	 * 
	 * @return Returns the collection of all movies.
	 */
	public List<Show> listShows() {
		return showRepo.findAll();
	}
}
