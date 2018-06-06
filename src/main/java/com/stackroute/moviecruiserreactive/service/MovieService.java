package com.stackroute.moviecruiserreactive.service;

import com.stackroute.moviecruiserreactive.domain.Movie;
import com.stackroute.moviecruiserreactive.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    Mono<Movie> saveMovie(Movie movie);
    Mono<Movie> getByMovieId(String id);
    Flux<Movie> getAllMovies();
    Mono<Void> deleteMovie(String id);
    public Flux<MovieEvent> generateMovieStream(String movieId);
}
