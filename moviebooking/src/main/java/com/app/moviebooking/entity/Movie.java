package com.app.moviebooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String genre;

    private String description;

    private String language;

    private Integer duration;

    private LocalDate releaseDate;

    @ManyToMany(mappedBy = "movie")
    @JoinTable(
            name = "movie_theater",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "theater_id")
    )
    private List<Theater> theaters;
}
