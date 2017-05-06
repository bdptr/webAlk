package com.cinema.service;

import java.util.List;

import com.cinema.model.Show;

public interface ShowService {

	/**
	 * Retrieves a list of shows of a specific cinema based on a given
	 * cinema name.
	 * 
	 * @param cinemaName
	 *            Represents the cinema we want to filter the shows by.
	 * @return Returns the list of shows of a specific cinema based on a
	 *         given cinema name.
	 */
	List<Show> findShowByCinema(String cinemaName);

	/**
	 * Retrieves a list of all shows.
	 * 
	 * @return Returns the list of all movies.
	 */
	List<Show> getShows();
}
