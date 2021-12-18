package com.movies.moviescatalogapi.service;
import java.util.ArrayList;
import java.util.List;
 
import com.movies.moviescatalogapi.model.Movie;
import com.movies.moviescatalogapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

	@Autowired
    MovieRepository movieRepository;
	
	public int addMovie(Movie movie)
    {
        
        movieRepository.save(movie);
        return movie.getId();
        
    }
    public List<Integer> addMovies(List<Movie> lstMovie)
    {
  
        List<Integer> movies = new ArrayList();
        
        for(Movie movie : lstMovie)
        {
            movieRepository.save(movie);
            movies.add(movie.getId());
        }
        return movies;
        
    }
 
    public List getAllMovies() {
        List movies = new ArrayList();
        movieRepository.findAll().forEach(movie -> movies.add(movie));
        return movies;
    }
 
    public Movie getMovieById(int id) {
        return movieRepository.findById(id).get();
    }
 
    public void saveOrUpdate(Movie movie) {
        movieRepository.save(movie);
    }
 
    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }
   
	public void deleteMovies(List<Movie> movies) {
		movieRepository.deleteAll(movies);
		
	}
	
	public void saveRating(Movie theRating){
        movieRepository.save(theRating);
    }
	
	public void saveReview(Movie theReview){
        movieRepository.save(theReview);
    }
	 
	public List<Movie> getMovieByName(String name) {
       return movieRepository.findByName(name);
	}
	public List<Movie> getMovieByGenre(String genre) {
		return movieRepository.findByGenre(genre);
	}
	public List<Movie> getMovieByRating(Float rating) {
		return movieRepository.findByRating(rating);
	}
	
	
	
}
