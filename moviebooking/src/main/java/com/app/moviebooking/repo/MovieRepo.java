package com.app.moviebooking.repo;

import com.app.moviebooking.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie,Long> {
}
