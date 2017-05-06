package com.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.dto.ShowDto;
import com.cinema.model.Show;
import com.cinema.service.ShowService;

@RestController
public class ShowController {

	@Autowired
	private ShowService showService;

	@RequestMapping(value = "/shows", method = RequestMethod.GET)
	public List<ShowDto> getShows() {
		List<Show> shows = showService.getShows();
		return shows.stream().map(show -> convertShowToShowDto(show)).collect(Collectors.toList());
	}

	private ShowDto convertShowToShowDto(Show show) {
		ShowDto showDto = new ShowDto();
		showDto.setId(show.getId());
		showDto.setShowDate(show.getShowDate().toString());
		showDto.setCinemaName(show.getCinema().getName());
		showDto.setMovieName(show.getMovie().getName());
		return showDto;
	}
}
