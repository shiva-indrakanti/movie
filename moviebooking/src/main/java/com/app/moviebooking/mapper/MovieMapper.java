package com.app.moviebooking.mapper;

import com.app.moviebooking.dto.response.MovieResponse;
import com.app.moviebooking.entity.Movie;
import com.app.moviebooking.entity.Theater;

import java.util.List;

public class MovieMapper {

    public static MovieResponse mapMovieEntityToResponse(Movie updatedMovie){
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setTitle(updatedMovie.getTitle());
        movieResponse.setDescription(updatedMovie.getDescription());
        movieResponse.setGenre(updatedMovie.getGenre());
        movieResponse.setLanguage(updatedMovie.getLanguage());
        movieResponse.setDuration(updatedMovie.getDuration());
        movieResponse.setReleaseDate(updatedMovie.getReleaseDate());
        List<Long> theaterIds = updatedMovie.getTheaters().stream().map(Theater::getId).toList();
        movieResponse.setTheaterIds(theaterIds);
        return movieResponse;
    }
}
