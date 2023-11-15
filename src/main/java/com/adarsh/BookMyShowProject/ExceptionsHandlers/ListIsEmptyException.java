package com.adarsh.BookMyShowProject.ExceptionsHandlers;


public class ListIsEmptyException extends RuntimeException{
	
	public ListIsEmptyException() {
        super(" this table is empty");
    }
	
}
