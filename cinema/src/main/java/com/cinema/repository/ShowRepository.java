package com.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cinema.model.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

	@Query("select s from Show s where s.cinema.name = ?1")
	public List<Show> findShowByCinema(String cinemaName);
}
