package com.stackroute.moviecruiserreactive.repositories;

import com.stackroute.moviecruiserreactive.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieReactiveRepository extends ReactiveMongoRepository<Movie, String>{
}
