package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cinema.model.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
