package com.stackroute.moviecruiserreactive.bootstrap;


import com.stackroute.moviecruiserreactive.domain.Movie;
import com.stackroute.moviecruiserreactive.repositories.MovieReactiveRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapMovieData implements CommandLineRunner {

    MovieReactiveRepository movieReactiveRepository;

    public BootstrapMovieData(MovieReactiveRepository movieReactiveRepository) {
        this.movieReactiveRepository = movieReactiveRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        movieReactiveRepository.save(Movie.builder()
                .name("Return of the Ghost")
                .posterPath("returnofghost.png")
                .comments("Sci Fi Movie")
                .releaseDate("01/01/1975")
                .voteAverage(3.5)
                .voteCount(12000)
                .build())
                .subscribe();
    }
}
