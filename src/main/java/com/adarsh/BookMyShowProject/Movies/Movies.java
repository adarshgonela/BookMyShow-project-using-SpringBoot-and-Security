package com.adarsh.BookMyShowProject.Movies;



import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Movies {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String moviename;
	private double movieprice;
	@Hidden
	private int totaltickets=100;
	
	private int remainingtickets ;
	
	@Version// concurrency control
	@Hidden
	private int version;
	
	public Movies(String string, int i) {
	}

	public Movies() {
		super();
	}
	
	
}
