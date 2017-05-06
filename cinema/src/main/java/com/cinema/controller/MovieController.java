package com.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.dto.MovieDto;
import com.cinema.model.Movie;
import com.cinema.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;
	private ModelMapper modelMapper = new ModelMapper();

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public List<MovieDto> getMovies() {
		List<Movie> movies = movieService.getMovies();
		return movies.stream().map(movie -> convertMovieToMovieDto(movie)).collect(Collectors.toList());
	}

	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
	public MovieDto getMovieById(@PathVariable("id") Long id) {
		Movie movie = movieService.getMovieById(id);
		return convertMovieToMovieDto(movie);
	}

	@RequestMapping(value = "/movies/{genre}", method = RequestMethod.GET)
	public List<MovieDto> listMoviesByGenre(@PathVariable("genre") String genre) {
		List<Movie> movies = movieService.listMoviesByGenre(genre);
		return movies.stream().map(movie -> convertMovieToMovieDto(movie)).collect(Collectors.toList());
	}

	@RequestMapping(value = "/movies/cinema/{name}", method = RequestMethod.GET)
	public List<MovieDto> listMoviesByCinemaName(@PathVariable("name") String name) {
		List<Movie> movies =  movieService.listMoviesByCinemaName(name);
		return movies.stream().map(movie -> convertMovieToMovieDto(movie)).collect(Collectors.toList());
	}

	private MovieDto convertMovieToMovieDto(Movie movie) {
		MovieDto movieDto = modelMapper.map(movie, MovieDto.class);
		return movieDto;
	}
}
