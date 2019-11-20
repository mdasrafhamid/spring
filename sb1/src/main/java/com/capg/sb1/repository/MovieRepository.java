package com.capg.sb1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capg.sb1.model.Movie;

@Repository
@Transactional
public class MovieRepository {

	@PersistenceContext
	private EntityManager em;
	
	public List<Movie> getAllMovies(){
		
		TypedQuery<Movie> query = em.createQuery("select m from Movie m",Movie.class);
		return query.getResultList();
	}
	
	public Movie save(Movie movie,long movieId) {
		
		if(movieId==-1) {
			em.persist(movie);
			return em.find(Movie.class, movie.getId());
		} else {
			Movie umovie = em.find(Movie.class, movieId);
			if(umovie!=null) {
				umovie.setTitle(movie.getTitle());
				umovie.setDescription(movie.getDescription());
				umovie.setDailyRentalRate(movie.getDailyRentalRate());
				umovie.setNumberInStock(movie.getNumberInStock());
				return umovie;
			}
		}
		return movie;

	}
	
	public Movie removeMovie(long movieId) {
		Movie m =  em.find(Movie.class, movieId);
		if(m!=null) {
			em.remove(m);
			return m;
		}
		return null;
	}
	
	public Movie getMovie(long movieId) {
		return em.find(Movie.class, movieId);
	}
}
