package com.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cinema.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query("select m from Movie m where m.genre = ?1")
	public List<Movie> findMoviesByGenre(String genre);
}
