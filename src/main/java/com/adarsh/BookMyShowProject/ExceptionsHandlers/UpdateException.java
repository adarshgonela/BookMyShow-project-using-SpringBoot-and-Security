package com.adarsh.BookMyShowProject.ExceptionsHandlers;

public class UpdateException extends RuntimeException {

	public UpdateException() {
		super("Please Enter the data correctly for Update Operation");
	}

}
