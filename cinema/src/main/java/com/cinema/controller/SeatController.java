package com.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.model.Seat;
import com.cinema.service.SeatService;

@RestController
public class SeatController {
	
	@Autowired
	private SeatService seatService;

	@RequestMapping(value = "/shows/{id}/seats", method = RequestMethod.GET)
	public List<Seat> findSeatsOfShow(@PathVariable("id") Long id) {
		return seatService.findSeatsOfShow(id);
	}

	@RequestMapping(value = "/buy/seat/{seatid}/user/{userid}", method = RequestMethod.POST)
	public ResponseEntity<?> buyTicket(@PathVariable("seatid") Long seatid, @PathVariable("userid") Long userid) {
		return seatService.buyTicket(seatid, userid);
	}
}
