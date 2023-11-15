package com.adarsh.BookMyShowProject.BOOKING;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adarsh.BookMyShowProject.ExceptionsHandlers.NoSuchElementToDeleteException;

@Repository
public class BookingDao {

	@Autowired
	private Booking_Repository bookingRepository;

	public Booking createBookingDao(Booking booking) {
		booking.setBookingTime(LocalDateTime.now());
		return bookingRepository.save(booking);
	}

	public List<Booking> GetAllBookingDao() {
		return bookingRepository.findAll();
	}

	public Booking UpdateBookingDao(Booking booking) {
		Optional<Booking> optional = bookingRepository.findById(booking.getId());
		if (optional.get() != null) {
			booking.setBookingTime(LocalDateTime.now());
			return bookingRepository.save(booking);
		} else {
			return null;
		}
	}

	public Booking GetBYID(int id) {
		Optional<Booking> optional = bookingRepository.findById(id);
		return optional.get();
	}

	public String DeleteMovieDao(int id) {
		Optional<Booking> optional = bookingRepository.findById(id);
		if (optional.get() != null) {
			bookingRepository.delete(optional.get());
			return "Booking deleted Successfully";
		} else {
			throw new NoSuchElementToDeleteException();
		}

	}
}
