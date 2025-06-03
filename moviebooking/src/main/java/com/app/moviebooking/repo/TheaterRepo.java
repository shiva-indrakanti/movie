package com.app.moviebooking.repo;

import com.app.moviebooking.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepo extends JpaRepository<Theater,Long> {
}
