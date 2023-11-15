package com.adarsh.BookMyShowProject.ExceptionsHandlers;

public class CorrectUserNotFoundException extends RuntimeException {

	 public CorrectUserNotFoundException() {
	        super("enter the correct username and password");
	    }
}
