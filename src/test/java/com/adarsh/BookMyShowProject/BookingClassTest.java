package com.adarsh.BookMyShowProject;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.adarsh.BookMyShowProject.BOOKING.Booking;
import com.adarsh.BookMyShowProject.BOOKING.BookingDao;
import com.adarsh.BookMyShowProject.BOOKING.Booking_Repository;

@SpringBootTest
public class BookingClassTest {
	@MockBean
	private Booking_Repository booking_Repository;

	@Autowired
	private BookingDao bookingDao;

	@Test
	public void BookingGetAllTesting() {

		List<Booking> mockBookings = Arrays.asList(new Booking(10, 100.0, 1, 1), new Booking(2, 100.0, 1, 1));
		when(booking_Repository.findAll()).thenReturn(mockBookings);
		List<Booking> result = bookingDao.GetAllBookingDao();
		assertEquals(mockBookings, result);
	}
	
	
}
