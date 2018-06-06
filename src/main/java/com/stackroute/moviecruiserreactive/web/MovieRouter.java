package com.stackroute.moviecruiserreactive.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
@Configuration
public class MovieRouter {
//    @Bean
//    public RouterFunction<ServerResponse> route(MovieHandler handler){
//        return RouterFunctions
//                .route(GET("/movieevents").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::streamMovie)
//                .andRoute(GET("/movie").and(accept(MediaType.ALL.APPLICATION_JSON)), handler::getAllMovies);
//
//    }

    @Bean
    public RouterFunction<ServerResponse> route(MovieHandler handler){
        return RouterFunctions
                .route((GET("/movies")).and(accept(MediaType.APPLICATION_JSON)),handler::getAllMovies)
                .andRoute((GET("/streammovies")).and(accept(MediaType.APPLICATION_STREAM_JSON)),handler::streamMovie);
    }

}