package com.adarsh.BookMyShowProject.Movies;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adarsh.BookMyShowProject.Config.ResponseStucture;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/movie")
public class MoviesController {

	@Autowired
	private MoviesService moviesService;

	@PostMapping("/new")
	 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@Operation(summary = "used to save movies", description = "When making the API request in Postman, please don't pass the data for the variables movieprice, totaltickets, remainingtickets, and version")
	public ResponseEntity<ResponseStucture<Movies>> AddController(@RequestBody Movies movies) {
		return moviesService.ADDUserService(movies);
	}

	@Operation(summary = "api is used for fetch all the Movies ", description = "This api is operated only by ADMIN and USER")
	@GetMapping("/all")
	@ResponseBody
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
	public ResponseStucture<Movies> getAllMovieController() {
		return moviesService.GetAllMovie();
	}

	@DeleteMapping("/delete") // http://localhost:8080/movie/delete?id=1
	 //@DeleteMapping("/{id}") // http://localhost:8080/movie/delete?id=1
	@Operation(summary = "used to Delete movies", description = "This api is operated only by ADMIN")
	 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseStucture<Movies> DeleteMovieController(@RequestParam int id) {
		return	moviesService.DeleteMovieService(id);
	}

	@Operation(summary = "api is used to Update the existing movies", description = "This api is operated only by ADMIN")
	@PutMapping("/update")
	 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String UpdateMovieController(@RequestBody Movies movies) {
		moviesService.UpdateMovieService(movies);
		return " with id " + movies.getId() + " successfully updated ";
	}

	@Operation(summary = "api is used to get the existing movies by ID", description = "This api is operated only by ADMIN and USER")
	@GetMapping("/{id}")//http://localhost:8080/movie/1
	@ResponseBody
	 @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
	public ResponseStucture<Movies> GEtBYID(@PathVariable int id) {
		return moviesService.GETbyIDService(id);
	}

}
