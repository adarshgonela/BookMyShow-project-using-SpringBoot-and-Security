package com.adarsh.BookMyShowProject.BOOKING;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.adarsh.BookMyShowProject.Config.ResponseStucture;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/booking")
@Api(tags = "Booking_Controller class", description = "It have Booking api's in Booking_Controller")

public class Booking_Controller {

	@Autowired
	private Booking_Service booking_Service;

	@Operation(summary = "Book the tickets for movies", description = "When making the API request in Postman, please  pass the data for the variables numberOfTickets,movieprice and Id of movies and Id of user"
			+ "\n This api is operated only by ADMIN and USER")

	@PostMapping("/create")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")

	public String bookTicket(@RequestBody Booking booking) {

		return booking_Service.createBookingService(booking);
	}

	@Operation(summary = "api is used for fetch all the Booking details ", description = "This api is operated only by ADMIN ")
	@GetMapping("/all")
	@ResponseBody
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseStucture<Booking> GetAllBookingController() {
		return booking_Service.GetAllBookingService();
	}

	@Operation(summary = "api is used for Update  the existing Movies ", description = "This api is operated only by ADMIN and USER")
	@PutMapping("/update")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String UpdateBookingController(@RequestBody Booking booking) {
		booking_Service.UpdateServiceMovie(booking);
		return "Booking data Updated";
	}

	@Operation(summary = "api is used for fetch Booking by ID ", description = "This api is operated only by ADMIN and USER")
	@GetMapping("/{id}")
	@ResponseBody
	@PreAuthorize("hasAuthority('ROLE_ADMIN')") // http://localhost:8080/booking/1
	public Booking GETByIDController(@PathVariable int id) {
		return booking_Service.GETBYIDservice(id);
	}

	@DeleteMapping("/delete") // http://localhost:8080/movie/delete?id=1
	@Operation(summary = "api is used for delete  the booking with ID ", description = "This api is operated only by ADMIN ")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String DeleteMovieController(@RequestParam int id) {
		booking_Service.DeleteMovieService(id);
		return "booking deleted with ID: " + id;
	}
}
