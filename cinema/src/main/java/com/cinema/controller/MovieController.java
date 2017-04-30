package com.cinema.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.model.Movie;
import com.cinema.model.Show;
import com.cinema.repository.MovieRepository;
import com.cinema.repository.ShowRepository;

@RestController
public class MovieController {

	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private ShowRepository showRepo;

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public List<Movie> listMovies() {
		return movieRepo.findAll();
	}

	@RequestMapping(value = "/movies/{genre}", method = RequestMethod.GET)
	public List<Movie> listMoviesByGenre(@PathVariable("genre") String genre) {
		return movieRepo.findMoviesByGenre(genre);
	}

	@RequestMapping(value = "/movies/cinema/{name}")
	public List<Movie> listMoviesByCinemaName(@PathVariable("name") String name) {
		List<Show> shows = showRepo.findShowByCinema(name);
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
