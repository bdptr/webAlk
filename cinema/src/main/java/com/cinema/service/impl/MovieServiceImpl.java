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

	public List<Movie> getMovies() {
		return movieRepo.findAll();
	}

	public List<Movie> findMoviesByGenre(String genre) {
		return movieRepo.findMoviesByGenre(genre);
	}

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
