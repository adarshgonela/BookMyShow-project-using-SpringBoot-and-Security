package com.adarsh.BookMyShowProject.BOOKING;

import java.util.List;


import com.adarsh.BookMyShowProject.Config.ResponseStucture;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.IdNotFoundException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.ListIsEmptyException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.MovieNotFoundException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.NoSuchElementToDeleteException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.NoUserFoundException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.UpdateException;
import com.adarsh.BookMyShowProject.Movies.Movies;
import com.adarsh.BookMyShowProject.Movies.Movies_Repository;
import com.adarsh.BookMyShowProject.Repository.UserInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class Booking_Service {
	@Autowired
	private BookingDao dao;

	@Autowired
	private UserInfoRepository userRepository;

	@Autowired
	private Movies_Repository moviesRepository;

	public String createBookingService(Booking booking) {

		com.adarsh.BookMyShowProject.entity.User user = booking.getUser();
		Movies movies = booking.getMovies();

		if (userRepository.existsById(user.getId())) {
			Optional<Movies> optionalMovies = moviesRepository.findById(movies.getId());
			if (optionalMovies.isPresent()) {
				Movies existingMovies = optionalMovies.get();
				int remainingTickets = existingMovies.getRemainingtickets();

				if (remainingTickets == 100 || (remainingTickets == 0 && existingMovies.getVersion() > 0)) {
					return "HOUSEFULL. Cannot make a booking.";

				} else if (remainingTickets == 0 && existingMovies.getVersion() == 0) {
					int remainingAfterBooking1 = existingMovies.getTotaltickets() - booking.getNumberOfTickets();
					existingMovies.setRemainingtickets(remainingAfterBooking1);
					moviesRepository.save(existingMovies);
					return booking.getNumberOfTickets() + " tickets booked successfully. Remaining tickets: "
							+ remainingAfterBooking1;
				} else if (booking.getNumberOfTickets() <= remainingTickets) {
					int remainingAfterBooking = remainingTickets - booking.getNumberOfTickets();

					existingMovies.setRemainingtickets(remainingAfterBooking);
					moviesRepository.save(existingMovies);
					return booking.getNumberOfTickets() + " tickets booked successfully. Remaining tickets: "
							+ remainingAfterBooking;
				} else {
					int availableTickets = existingMovies.getTotaltickets() - remainingTickets;
					return "Only " + remainingTickets + " tickets available. you can book only " + remainingTickets
							+ " tickets";
				}
			} else {
				throw new MovieNotFoundException();
			}
		} else {
			throw new NoUserFoundException();
		}
	}

	public ResponseStucture<Booking> GetAllBookingService() {
		ResponseStucture<Booking> responseStucture = new ResponseStucture<Booking>();
		responseStucture.setStatus(HttpStatus.FOUND.value());
		responseStucture.setMessage("Successsfully Fetched");
		List<Booking> list = dao.GetAllBookingDao();

		if (list.isEmpty()) {
			throw new ListIsEmptyException();
		}
		responseStucture.setDataAll(list);
		return responseStucture;

	}

	public Booking UpdateServiceMovie(Booking booking) {
		if (booking != null) {
			dao.UpdateBookingDao(booking);
		} else {
			throw new UpdateException();
		}
		return booking;
	}

	public Booking GETBYIDservice(int id) {
		// return dao.GetBYID(id);
		try {
			Booking booking = dao.GetBYID(id);
			return booking;

		} catch (Exception e) {
			throw new IdNotFoundException();
		}
	}

	public String DeleteMovieService(int id) {
		ResponseStucture<Booking> responseStucture = new ResponseStucture<Booking>();
		responseStucture.setStatus(HttpStatus.FOUND.value());
		responseStucture.setMessage("Successsfully Deleted");

		try {
			return dao.DeleteMovieDao(id);
		} catch (Exception e) {
			throw new NoSuchElementToDeleteException();
		}
	}
}
