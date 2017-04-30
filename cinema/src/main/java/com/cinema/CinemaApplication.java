package com.cinema;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import com.cinema.model.Cinema;
import com.cinema.model.Movie;
import com.cinema.model.Seat;
import com.cinema.model.Show;
import com.cinema.model.User;
import com.cinema.model.UserRole;
import com.cinema.repository.CinemaRepository;
import com.cinema.repository.MovieRepository;
import com.cinema.repository.SeatRepository;
import com.cinema.repository.ShowRepository;
import com.cinema.repository.UserRepository;
import com.cinema.repository.UserRolesRepository;

@SpringBootApplication(scanBasePackages = "com.cinema")
public class CinemaApplication implements CommandLineRunner {

	@Autowired
	private CinemaRepository cinemaRepo;
	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private SeatRepository seatRepo;
	@Autowired
	private ShowRepository showRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserRolesRepository rolesRepo;

	@Override
	public void run(String... arg0) throws Exception {

		for (int i = 0; i < 10; i++) {
			Cinema cin = new Cinema();
			cin.setName("Cinema" + i);

			List<Show> shows = new ArrayList<>();

			for (int j = 0; j < 10; j++) {
				Show show = new Show();
				show.setShowDate(
						new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(new Random(j).nextInt(100))));

				List<Seat> seats = new ArrayList<>();

				for (int k = 0; k < 50; k++) {
					Seat seat = new Seat();
					seat.setIsFree(new Random(k).nextInt() % 2 == 0);
					seats.add(seat);

					seatRepo.save(seat);
				}

				show.setSeats(seats);
				shows.add(show);

				showRepo.save(show);
			}

			Cinema savedCinema = cinemaRepo.save(cin);

			List<Show> foundShows = showRepo.findAll(new PageRequest(i, 10)).getContent();

			savedCinema.setShows(foundShows);
			cinemaRepo.save(savedCinema);
		}

		for (int i = 0; i < 10; i++) {
			Movie movie = new Movie();
			movie.setName("Movie" + i);

			String genre = "";

			if (i % 2 == 0 && i % 3 != 0) {
				genre = "action";
			} else if (i % 3 == 0) {
				genre = "horror";
			} else {
				genre = "comedy";
			}

			movie.setGenre(genre);

			Movie savedMovie = movieRepo.save(movie);

			List<Show> shows = new ArrayList<>();
			shows = showRepo.findAll();

			for (int j = i * 10; j < i * 10 + 10; j++) {
				savedMovie.addShow(shows.get(j));
			}

			movieRepo.save(savedMovie);
		}

		User user = new User();
		user.setName("user");
		user.setPassword("password");
		user.setUserDetails("original user details");

		userRepo.save(user);

		User costumer = new User();
		costumer.setName("costumer");
		costumer.setPassword("password");
		costumer.setUserDetails("original costumer details");

		userRepo.save(costumer);

		UserRole roleUser = new UserRole();
		roleUser.setRole("ROLE_USER");
		roleUser.setUserid(1L);
		rolesRepo.save(roleUser);

		UserRole roleCostumer = new UserRole();
		roleCostumer.setRole("ROLE_COSTUMER");
		roleCostumer.setUserid(2L);
		rolesRepo.save(roleCostumer);
	}

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}
}
