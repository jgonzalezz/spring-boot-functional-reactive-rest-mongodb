package com.stackroute.moviecruiserreactive.web;


import com.stackroute.moviecruiserreactive.domain.Movie;
import com.stackroute.moviecruiserreactive.domain.MovieEvent;
import com.stackroute.moviecruiserreactive.service.MovieService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class MovieHandler {
    private MovieService movieService;

    public MovieHandler(MovieService movieService) {
        this.movieService = movieService;
    } ;

    public Mono<ServerResponse> getAllMovies(ServerRequest serverRequest) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.movieService.getAllMovies(), Movie.class);

    }

    public Mono<ServerResponse> streamMovie(ServerRequest request){
        return ok().contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(this.movieService.generateMovieStream(request.queryParam("movieId").toString()),MovieEvent.class);
    }


}
