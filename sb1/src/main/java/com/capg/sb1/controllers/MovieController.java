package com.capg.sb1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.sb1.model.Movie;
import com.capg.sb1.services.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	
	public MovieController() {
		super();
	}

	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}

	@GetMapping(path="/movies")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	@PostMapping(path="/movies")
	public Movie saveMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}
	
	@DeleteMapping(path="/movies/{movieId}")
	public Movie removeMovie(@PathVariable long movieId) {
		return movieService.removeMovie(movieId);
	}
	
	@PutMapping(path="/movies/{movieId}")
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable long movieId) {
		return movieService.updateMovie(movieId,movie);
	}
	
	@GetMapping(path="/movies/{movieId}")
	public Movie getMovie(@PathVariable long movieId) {
		return movieService.getMovie(movieId);
	}
	
	@GetMapping(path="/movies/movie")
	public Movie getMovie(@RequestParam String title) {
		return movieService.getMovie(title);
	}
}
