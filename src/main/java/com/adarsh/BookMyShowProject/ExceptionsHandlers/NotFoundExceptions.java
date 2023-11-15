package com.adarsh.BookMyShowProject.ExceptionsHandlers;



public class NotFoundExceptions extends RuntimeException{

	public NotFoundExceptions() {
		super("the id you are trying to delete is not Found in DataBase");
	}
	
}
