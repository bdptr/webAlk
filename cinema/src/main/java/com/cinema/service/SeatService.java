package com.cinema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cinema.dto.BuyDto;
import com.cinema.model.Seat;

public interface SeatService {

	/**
	 * Retrieves a list of seats for a specific show.
	 * 
	 * @param showId
	 *            The identifier of the show.
	 * @return Represents the seats for a specific show.
	 */
	List<Seat> findSeatsOfShow(Long showId);
	
	/**
	 * TODO
	 * @param id
	 * @return
	 */
	Seat getSeatById(Long id);
	
	/**
	 * TODO
	 * @param buyDto
	 */
	ResponseEntity<?> buy(BuyDto buyDto);

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
	/*ResponseEntity<?> buyTicket(Long seatid, Long userid);*/
}
