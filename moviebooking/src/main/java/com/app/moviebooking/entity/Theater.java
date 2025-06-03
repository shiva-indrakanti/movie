package com.app.moviebooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theaterName;

    private String location;

    private int seatCapacity;

    private String screenType;

    @ManyToMany(mappedBy = "theaters")
    private List<Movie> movies;
}
