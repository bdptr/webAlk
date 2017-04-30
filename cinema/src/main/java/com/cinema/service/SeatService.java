package com.cinema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cinema.model.Seat;

public interface SeatService {
	List<Seat> findSeatsOfShow(Long id);

	ResponseEntity<?> buyTicket(Long seatid, Long userid);
}
