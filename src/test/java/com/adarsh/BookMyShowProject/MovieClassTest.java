package com.adarsh.BookMyShowProject;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.adarsh.BookMyShowProject.Movies.Movies;
import com.adarsh.BookMyShowProject.Movies.MoviesDao;
import com.adarsh.BookMyShowProject.Movies.Movies_Repository;
@SpringBootTest
public class MovieClassTest {

	@MockBean
	private Movies_Repository movies_Repository;

	@Autowired
	private MoviesDao moviesDao;

	@Test
	public void MovieGetAllTesting() {

		List<Movies> mockBookings = Arrays.asList(new Movies("adarsh",200));
		when(movies_Repository.findAll()).thenReturn(mockBookings);
		List<Movies> result = moviesDao.GetAllMovie();
		assertEquals(mockBookings, result);
	}
	
	
}
