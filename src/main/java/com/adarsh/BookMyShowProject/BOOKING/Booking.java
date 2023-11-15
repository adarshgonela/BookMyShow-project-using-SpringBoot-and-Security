package com.adarsh.BookMyShowProject.BOOKING;

import java.time.LocalDateTime;

import com.adarsh.BookMyShowProject.Movies.Movies;
import com.adarsh.BookMyShowProject.entity.User;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Hidden // this annotation is used to hide the variable in swagger UI(user Interface)
	private LocalDateTime bookingTime;
	private int numberOfTickets;
	private double movieprice;

	@Hidden // this annotation is used to hide the variable in swagger UI(user Interface)
	private double totalPrice;

	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movies movies;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@PrePersist
	public void calculateTotalAmount() {
		if (movieprice > 0 && numberOfTickets > 0) {
			totalPrice = movieprice * numberOfTickets;
		}

	}

	@PreUpdate
	public void calculateTotalAmountUpdate() {
		if (movieprice > 0 && numberOfTickets > 0) {
			totalPrice = movieprice * numberOfTickets;
		}
	}

	public Booking(int numberOfTickets2, double movieprice2, int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public Booking() {
		super();
	}

}
