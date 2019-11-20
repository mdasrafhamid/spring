package com.capg.sb1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.sb1.model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long>{

	Movie findByTitle(String title);
	List<Movie> findAllByTitle(String title);
	List<Movie> findAllByNumberInStockGreaterThan(int number);
	
//	@Query("Select m.title from Movie m where m.title=?")
//	Movie myOwnMethod(String title);
}
