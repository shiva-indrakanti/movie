package com.app.moviebooking.service;

import com.app.moviebooking.dto.NewMovieRequest;
import com.app.moviebooking.entity.Movie;
import com.app.moviebooking.entity.Theater;
import com.app.moviebooking.exception.TheaterNotFoundException;
import com.app.moviebooking.repo.MovieRepo;
import com.app.moviebooking.repo.TheaterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private TheaterRepo theaterRepo;

    public String addMovie(NewMovieRequest request) {
        Movie movieEntity = new Movie();
        movieEntity.setTitle(request.getTitle());
        movieEntity.setGenre(request.getGenre());
        movieEntity.setDescription(request.getDescription());
        movieEntity.setLanguage(request.getLanguage());
        movieEntity.setDuration(request.getDuration());

        List<Long> requestedIds = request.getTheaterIds();
        List<Theater> theaterList = theaterRepo.findAllById(request.getTheaterIds());
        if(requestedIds.size() != theaterList.size()){
            List<Long> foundTheaters = theaterList.stream().map(Theater::getId).toList();
            List<Long> missingTheaters = requestedIds.stream().filter(id -> !foundTheaters.contains(id)).toList();
            throw new TheaterNotFoundException(missingTheaters,"Theater lookup failed: some IDs provided do not exist.");
        }
       // movieEntity.setTheaters();
        movieRepo.save(movieEntity);
        return "Movie has been added successfully";
    }
}
