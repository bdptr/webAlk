package com.cinema.service;

import java.util.List;

import com.cinema.model.Movie;

public interface MovieService {

	/**
	 * Retrieves a list of all movies.
	 * 
	 * @return Returns the list of all movies.
	 */
	List<Movie> listMovies();

	/**
	 * Retrieves a list of movies based on a given genre.
	 * 
	 * @param genre
	 *            Represents the genre we want to filter the movies by.
	 * @return Returns a list of movies filtered by a genre.
	 */
	List<Movie> listMoviesByGenre(String genre);

	/**
	 * Retrieves a list of movies of a specific cinema based on a given cinema name.
	 * 
	 * @param cinema
	 *            Represents the cinema we want to filter the movies by.
	 * @return Returns a list of movies of a specific cinema based on a given cinema name.
	 */
	List<Movie> listMoviesByCinemaName(String cinema);
}
