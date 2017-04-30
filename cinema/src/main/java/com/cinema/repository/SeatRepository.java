package com.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cinema.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

	@Query("select se from Show s join s.seats se where s.id = ?1")
	public List<Seat> findSeatsOfShow(Long id);
}
