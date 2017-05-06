package com.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.dto.BuyDto;
import com.cinema.dto.SeatDto;
import com.cinema.model.Seat;
import com.cinema.service.SeatService;

@RestController
public class SeatController {

	@Autowired
	private SeatService seatService;
	private ModelMapper modelMapper = new ModelMapper();

	@RequestMapping(value = "/shows/{id}/seats", method = RequestMethod.GET)
	public List<SeatDto> findSeatsOfShow(@PathVariable("id") Long id) {
		List<Seat> seats = seatService.findSeatsOfShow(id);
		return seats.stream().map(seat -> convertSeatToSeatDto(seat)).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/buy/seat", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buy(@RequestBody BuyDto buyDto) {
		return seatService.buy(buyDto);
	}

	private SeatDto convertSeatToSeatDto(Seat seat) {
		SeatDto seatDto = modelMapper.map(seat, SeatDto.class);
		return seatDto;
	}

	/*@RequestMapping(value = "/buy/seat/{seatid}/user/{userid}", method = RequestMethod.POST)
	public ResponseEntity<?> buyTicket(@PathVariable("seatid") Long seatid, @PathVariable("userid") Long userid) {
		return seatService.buyTicket(seatid, userid);
	}*/

	/*private Seat convertSeatDtoToEntity(SeatDto seatDto) throws ParseException {
		Seat seat = modelMapper.map(seatDto, Seat.class);

		if (seatDto.getId() != null) {
			Seat oldSeat = seatService.getSeatById(seatDto.getId());
			seat.setIsFree(oldSeat.getIsFree());
		}
		return seat;
	}*/
}
