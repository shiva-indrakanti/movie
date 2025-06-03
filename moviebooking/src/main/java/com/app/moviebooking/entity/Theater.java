package com.app.moviebooking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theaterName;

    private String location;

    private int capacity;

    private String screenType;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
