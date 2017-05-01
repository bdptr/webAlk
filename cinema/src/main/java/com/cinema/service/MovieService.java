package com.cinema.service;

import java.util.List;

import com.cinema.model.Movie;

public interface MovieService {

	/**
	 * Retrieves a collection of all movies.
	 * 
	 * @return Returns the collection of all movies.
	 */
	List<Movie> listMovies();

	/**
	 * Retrieves a collection of movies based on a given genre.
	 * 
	 * @param genre
	 *            Represents the genre we want to filter the movies by.
	 * @return Returns a collection of movies filtered by a genre.
	 */
	List<Movie> listMoviesByGenre(String genre);

	/**
	 * Retrieves a collection of movies of a specific cinema based on a given cinema name.
	 * 
	 * @param cinema
	 *            Represents the cinema we want to filter the movies by.
	 * @return Returns a collection of movies of a specific cinema based on a given cinema name.
	 */
	List<Movie> listMoviesByCinemaName(String cinema);
}
