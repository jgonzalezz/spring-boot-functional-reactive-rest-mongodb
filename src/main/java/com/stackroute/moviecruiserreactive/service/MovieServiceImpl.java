package com.stackroute.moviecruiserreactive.service;

import com.stackroute.moviecruiserreactive.domain.Movie;
import com.stackroute.moviecruiserreactive.domain.MovieEvent;
import com.stackroute.moviecruiserreactive.repositories.MovieReactiveRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;


@Service
public class MovieServiceImpl implements MovieService {

    public MovieServiceImpl(MovieReactiveRepository movieReactiveRepository) {
        this.movieReactiveRepository = movieReactiveRepository;
    }

    private MovieReactiveRepository movieReactiveRepository;

    @Override
    public Mono<Movie> saveMovie(Movie movie) {
        return movieReactiveRepository.save(movie);
    }

    @Override
    public Mono<Movie> getByMovieId(String id) {
        return movieReactiveRepository.findById(id);
    }

    @Override
    public Flux<Movie> getAllMovies() {
        return movieReactiveRepository.findAll();
    }

    @Override
    public Mono<Void> deleteMovie(String id) {
        return movieReactiveRepository.deleteById(id);
    }


    public Flux<MovieEvent> generateMovieStream(String movieId){
        return Flux.<MovieEvent>generate(movieSynchronousSink->movieSynchronousSink.next(new MovieEvent(movieId,new Date())))
                .delayElements(Duration.ofSeconds(2));
    }
}
