package com.adarsh.BookMyShowProject.ExceptionsHandlers;

public class NoSuchElementToDeleteException extends RuntimeException{
public NoSuchElementToDeleteException() {
	super("There is no such ID present in database");
}
}
