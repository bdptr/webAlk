package com.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.model.Movie;
import com.cinema.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public List<Movie> listMovies() {
		return movieService.listMovies();
	}
	
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
	public Movie getMovieById(@PathVariable("id") Long id) {
		return movieService.getMovieById(id);
	}

	@RequestMapping(value = "/movies/{genre}", method = RequestMethod.GET)
	public List<Movie> listMoviesByGenre(@PathVariable("genre") String genre) {
		return movieService.listMoviesByGenre(genre);
	}

	@RequestMapping(value = "/movies/cinema/{name}", method = RequestMethod.GET)
	public List<Movie> listMoviesByCinemaName(@PathVariable("name") String name) {
		return movieService.listMoviesByCinemaName(name);
	}
}
