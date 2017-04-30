package com.cinema.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true)
	private String name;
	
	private String genre;
	
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
	private List<Show> upcomingShows = new ArrayList<>();
	
	public Movie(){}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Show> getShows() {
		return upcomingShows;
	}

	public void setShows(List<Show> shows) {
		
		for(Show show : shows)
		{
			show.setMovie(this);
		}
		
		this.upcomingShows = shows;
	}
	
	public void addShow(Show show)
	{
		show.setMovie(this);
		this.upcomingShows.add(show);
	}
}
