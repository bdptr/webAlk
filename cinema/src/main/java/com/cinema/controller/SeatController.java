package com.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.model.Seat;
import com.cinema.model.User;
import com.cinema.repository.SeatRepository;
import com.cinema.repository.UserRepository;

@RestController
public class SeatController {

	@Autowired
	private SeatRepository seatRepo;

	@Autowired
	private UserRepository userRepo;

	@RequestMapping(value = "/shows/{id}/seats", method = RequestMethod.GET)
	public List<Seat> findSeatsOfShow(@PathVariable("id") Long id) {
		return seatRepo.listSeatsOfShow(id);
	}

	@RequestMapping(value = "/buy/seat/{seatid}/user/{userid}", method = RequestMethod.POST)
	public ResponseEntity<?> buyTicket(@PathVariable("seatid") Long seatid, @PathVariable("userid") Long userid) {
		Seat seat = seatRepo.findOne(seatid);

		if (seat.getIsFree()) {
			seat.setIsFree(false);
			User user = userRepo.findOne(userid);
			user.addSeat(seat);
			userRepo.save(user);

			return new ResponseEntity<Seat>(seatRepo.save(seat), HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
		}
	}
}
