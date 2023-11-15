package com.adarsh.BookMyShowProject.ExceptionsHandlers;

public class NoUserFoundException extends RuntimeException {
	
	public NoUserFoundException(){
		super("User with ID is not found");
	}
}
