package com.adarsh.BookMyShowProject.ExceptionsHandlers;

public class MovieNotFoundException extends RuntimeException {

	public MovieNotFoundException() {
		super("the movie id you entered is not correct");
	}

}
