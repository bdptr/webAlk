package com.cinema.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.model.Movie;
import com.cinema.model.Show;
import com.cinema.repository.MovieRepository;
import com.cinema.repository.ShowRepository;
import com.cinema.service.MovieService;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private ShowRepository showRepo;

	/**
	 * Retrieves a collection of all movies.
	 * 
	 * @return Returns the collection of all movies.
	 */
	public List<Movie> listMovies() {
		return movieRepo.findAll();
	}

	/**
	 * Retrieves a collection of movies based on a given genre.
	 * 
	 * @param genre
	 *            Represents the genre we want to filter the movies by.
	 * @return Returns a collection of movies filtered by a genre.
	 */
	public List<Movie> listMoviesByGenre(String genre) {
		return movieRepo.findMoviesByGenre(genre);
	}

	/**
	 * Retrieves a collection of movies of a specific cinema based on a given cinema name.
	 * 
	 * @param cinema
	 *            Represents the cinema we want to filter the movies by.
	 * @return Returns a collection of movies of a specific cinema based on a given cinema name.
	 */
	public List<Movie> listMoviesByCinemaName(String cinema) {
		List<Show> shows = showRepo.findShowByCinema(cinema);
		List<Movie> movies = movieRepo.findAll();

		List<Movie> result = new ArrayList<>();

		for (Show show : shows) {
			for (Movie movie : movies) {
				if (show.getMovie().getId() == movie.getId()) {
					result.add(movie);
				}
			}
		}

		return result;
	}
}
