package com.cinema.service;

import java.util.List;

import com.cinema.model.Movie;

public interface MovieService {
	List<Movie> getMovies();

	List<Movie> findMoviesByGenre(String genre);

	List<Movie> listMoviesByCinemaName(String cinema);
}
