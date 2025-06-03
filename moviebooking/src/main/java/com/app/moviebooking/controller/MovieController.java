package com.app.moviebooking.controller;

import com.app.moviebooking.dto.NewMovieRequest;
import com.app.moviebooking.dto.response.MovieResponse;
import com.app.moviebooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody NewMovieRequest request){
        return new ResponseEntity<>(movieService.addMovie(request), HttpStatus.CREATED);
    }

    @PostMapping("/update-movie/{movieId}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable(name = "movieId") Long movieId , @RequestBody NewMovieRequest request){
        return new ResponseEntity<>(movieService.updateMovie(movieId,request), HttpStatus.OK);
    }

    @DeleteMapping("/remove-movie/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable(name = "movieId") Long movieId){
        return new ResponseEntity<>(movieService.removeMovie(movieId),HttpStatus.OK);
    }
}
