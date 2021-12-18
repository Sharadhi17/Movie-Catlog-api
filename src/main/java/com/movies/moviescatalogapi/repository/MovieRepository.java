package com.movies.moviescatalogapi.repository;

import com.movies.moviescatalogapi.model.Movie;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface MovieRepository extends CrudRepository<Movie, Integer> {

	public List<Movie> findByName(String name);

	public List<Movie> findByGenre(String genre);
	
	public List<Movie> findByRating(Float rating);
	
}


