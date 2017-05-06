package com.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cinema.dto.BuyDto;
import com.cinema.model.Seat;
import com.cinema.model.User;
import com.cinema.repository.SeatRepository;
import com.cinema.repository.UserRepository;
import com.cinema.service.SeatService;

@Service("seatService")
public class SeatServiceImpl implements SeatService {

	@Autowired
	private SeatRepository seatRepo;

	@Autowired
	private UserRepository userRepo;

	/**
	 * Retrieves a list of seats for a specific show.
	 * 
	 * @param showId
	 *            The identifier of the show.
	 * @return Represents the seats for a specific show.
	 */
	public List<Seat> findSeatsOfShow(Long showId) {
		return seatRepo.findSeatsOfShow(showId);
	};

	/**
	 * TODO
	 * 
	 * @param id
	 * @return
	 */
	public Seat getSeatById(Long id) {
		return seatRepo.getSeatById(id);
	};

	/**
	 * TODO
	 * 
	 * @param buyDto
	 */
	public ResponseEntity<?> buy(BuyDto buyDto) {
		Seat seat = seatRepo.findOne(buyDto.getSeatId());

		if (seat.getIsFree()) {
			seat.setIsFree(false);
			User user = userRepo.findOne(buyDto.getUserId());
			user.addSeat(seat);
			userRepo.save(user);

			return new ResponseEntity<Seat>(seatRepo.save(seat), HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
		}
	};

	/**
	 * Updates a specific seat's availability flag based on a given seat
	 * identifier and connects the seat with a user based on a given user
	 * identifier.
	 * 
	 * @param seatid
	 *            The identifier of the seat.
	 * @param userid
	 *            The identifier of the user.
	 * @return Seat data.
	 */
	/*public ResponseEntity<?> buyTicket(Long seatid, Long userid) {
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
	}*/
}
