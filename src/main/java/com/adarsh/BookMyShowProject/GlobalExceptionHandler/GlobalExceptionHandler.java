package com.adarsh.BookMyShowProject.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.adarsh.BookMyShowProject.ExceptionsHandlers.CorrectUserNotFoundException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.CustomException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.IdNotFoundException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.ListIsEmptyException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.MovieNotFoundException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.NoSuchElementToDeleteException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.NoUserFoundException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.NotFoundExceptions;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.SaveException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.UpdateException;

@ControllerAdvice // GlobalExceptionHandler
public class GlobalExceptionHandler {

	@ExceptionHandler(ListIsEmptyException.class)
	public ResponseEntity<String> handleListIsEmptyException(ListIsEmptyException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

	@ExceptionHandler(CorrectUserNotFoundException.class)
	public ResponseEntity<String> handleCorrectUserNotFoundException(CorrectUserNotFoundException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	}

	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<String> handleNoUserFoundException(NoUserFoundException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	}

	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<String> handleMovieNotFoundException(MovieNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> handleIdNotFoundException(IdNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> handleCustomException(CustomException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

	@ExceptionHandler(NotFoundExceptions.class)
	public ResponseEntity<String> handleNotFoundExceptions(NotFoundExceptions e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

	@ExceptionHandler(NoSuchElementToDeleteException.class)
	public ResponseEntity<String> handleNoSuchElementToDeleteException(NoSuchElementToDeleteException e) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
	}

	@ExceptionHandler(SaveException.class)
	public ResponseEntity<String> handleSaveException(SaveException e) {
		return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT).body(e.getMessage());
	}

	@ExceptionHandler(UpdateException.class)
	public ResponseEntity<String> handleUpdateException(UpdateException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

}
