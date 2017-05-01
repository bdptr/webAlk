package com.cinema.service;

import java.util.List;

import com.cinema.model.Show;

public interface ShowService {

	/**
	 * Retrieves a collection of shows of a specific cinema based on a given
	 * cinema name.
	 * 
	 * @param cinemaName
	 *            Represents the cinema we want to filter the shows by.
	 * @return Returns the collection of shows of a specific cinema based on a
	 *         given cinema name.
	 */
	List<Show> findShowByCinema(String cinemaName);

	/**
	 * Retrieves a collection of all shows.
	 * 
	 * @return Returns the collection of all movies.
	 */
	List<Show> listShows();
}
