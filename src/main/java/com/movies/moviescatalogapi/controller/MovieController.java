package com.movies.moviescatalogapi.controller;
import java.util.List;

import com.movies.moviescatalogapi.model.Movie;
import com.movies.moviescatalogapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController

public class MovieController {

	@Autowired
    MovieService movieService;
	
	@PostMapping("/movie/add")
    private String addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return "Movie added";
    }
	
    @PostMapping("/movies/add")
    private String addMovies(@RequestBody List<Movie> lsMovie) {
        movieService.addMovies(lsMovie);
        return "All Movies added";
    }
 
    @PutMapping("/movies")
    private int saveMovie(@RequestBody Movie movie) {
        movieService.saveOrUpdate(movie);
        return movie.getId();
    }
    
    @GetMapping("/movies/{id}")
    private Movie getMovie(@PathVariable("id") int id) {
        return movieService.getMovieById(id);
    }
    
    @GetMapping("/movies")
    private List getAllMovies() {
        return movieService.getAllMovies();
    }
 
    @DeleteMapping("/movie/delete")
    private String deleteMovie(@RequestBody Movie movie) {
        movieService.delete(movie);
        return "Successfully deleted single movie";
    }
    
    @DeleteMapping("/movies/delete")
    private String deleteMovies(@RequestBody List<Movie> movies) {
    	movieService.deleteMovies(movies);
    	return "Successfully deleted selected movies";
    }

    @PostMapping("/addRating")
    public String addRating(@RequestBody Movie theRating) {
        movieService.saveRating(theRating);
        return "redirect:/movie/byId?Id=" + theRating.getId();
    }
    
    @PostMapping("/addReview")
    public String addReview(@RequestBody Movie theReview) {
        movieService.saveReview(theReview);
        return "redirect:/movie/byId?Id=" + theReview.getId();
    }
    
    @GetMapping("/movie/name/{name}")
    private List<Movie> getMovieByName(@PathVariable String name){
        return movieService.getMovieByName(name);
    }
    
    @GetMapping("/movie/genre/{genre}")
    private List<Movie> getMovieByGenre(@PathVariable String genre){
        return movieService.getMovieByGenre(genre);
    }
    
    @GetMapping("/movie/rating/{rating}")
    private List<Movie> getMovieByRating(@PathVariable Float rating){
        return movieService.getMovieByRating(rating);
    }
    
}
