package com.stackroute.moviecruiserreactive.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Movie {

    @Id
    private String id;
    private String name;
    private String comments;
    private String posterPath;
    private String releaseDate;
    private Double voteAverage;
    private Integer voteCount;

}
