package com.app.moviebooking.repo;

import com.app.moviebooking.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepo extends JpaRepository<Movie,Long> {

    Optional<Movie> findByTitle(String title);
}
