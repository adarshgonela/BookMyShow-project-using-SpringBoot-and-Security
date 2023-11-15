package com.adarsh.BookMyShowProject.ExceptionsHandlers;

public class IdNotFoundException extends RuntimeException {

	public IdNotFoundException() {
		super("the ID you want to retreieve is not found in Database");
	}

}
