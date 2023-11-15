package com.adarsh.BookMyShowProject.Movies;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adarsh.BookMyShowProject.ExceptionsHandlers.NoSuchElementToDeleteException;

@Repository
public class MoviesDao {

	@Autowired
	private Movies_Repository movies_Repository;

	public Movies AddMovie(Movies movies) {
		return movies_Repository.save(movies);
	}

	public List<Movies> GetAllMovie() {
		return movies_Repository.findAll();
	}

	public Movies DeleteMovieDao(int id) {
		Optional<Movies> optional = movies_Repository.findById(id);
		if (optional.isPresent()) {
		//	return movies_Repository.delete(optional.get());
		Movies movies	=movies_Repository.findById(id).get();
	movies_Repository.deleteById(id);
		return movies;
		} else {
			throw new NoSuchElementToDeleteException();
		}

		
		
	}

	public Movies UpdateMoviesDao(Movies movies) {
		Optional<Movies> optional = movies_Repository.findById(movies.getId());
		if (optional.get() != null) {
			return movies_Repository.save(movies);
		} else {
			return null;
		}

	}

	public Movies GetBYIDDao(int id) {
		Optional<Movies> optional = movies_Repository.findById(id);
		return optional.get();
	}

}
