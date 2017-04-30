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
public class Cinema {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true, updatable=false)
	private String name;
	
	@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
	private List<Show> cinemaShows = new ArrayList<>();
	
	public Cinema(){}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Show> getShows() {
		return cinemaShows;
	}

	public void setShows(List<Show> shows) {
		
		for(Show show : shows)
		{
			show.setCinema(this);
		}
		
		this.cinemaShows = shows;
	}
	
	public void addShow(Show show)
	{
		show.setCinema(this);
		this.cinemaShows.add(show);
	}
}
