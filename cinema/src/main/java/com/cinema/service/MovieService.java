package com.cinema.service;

import java.util.List;

import com.cinema.model.Movie;

public interface MovieService {
	List<Movie> listMovies();

	List<Movie> listMoviesByGenre(String genre);

	List<Movie> listMoviesByCinemaName(String cinema);
}
