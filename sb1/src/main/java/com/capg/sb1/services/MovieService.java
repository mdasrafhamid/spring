package com.capg.sb1.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.sb1.model.Movie;
import com.capg.sb1.repository.MovieRepo;

@Service
@Transactional
public class MovieService {

	@Autowired
	public MovieRepo movieRepo;
	
	public MovieService(MovieRepo movieRepo) {
		super();
		this.movieRepo = movieRepo;
	}

	public List<Movie> getAllMovies(){
		return movieRepo.findAll();
	}
	
	public Movie getMovie(long movieId) {
		Optional<Movie> optionalMovie = movieRepo.findById(movieId);
		if(optionalMovie.isPresent()) {
			return optionalMovie.get();
		}else return null;
	}
	
	public Movie getMovie(String title) {
		return movieRepo.findByTitle(title);
	}
	
	public Movie saveMovie(Movie movie) {
		return movieRepo.save(movie);
	}
	
	public Movie removeMovie(long movieId) {
		Optional<Movie> optionalMovie = movieRepo.findById(movieId);
		if(optionalMovie.isPresent()) {
			movieRepo.delete(optionalMovie.get());
			return optionalMovie.get();
		}else return null;
	}
	
	public Movie updateMovie(long movieId, Movie movie) {
		Optional<Movie> optionalMovie = movieRepo.findById(movieId);
		if(optionalMovie.isPresent()) {
			Movie umovie = optionalMovie.get();
			umovie.setDailyRentalRate(movie.getDailyRentalRate());
			umovie.setNumberInStock(movie.getNumberInStock());
			umovie.setTitle(movie.getTitle());
			umovie.setDescription(movie.getDescription());
			
			return umovie;
		}else return null;
	}
}
