package com.app.moviebooking.mapper;

import com.app.moviebooking.dto.response.MovieDetailsResponse;
import com.app.moviebooking.dto.response.MovieUpdateResponse;
import com.app.moviebooking.dto.response.TheaterResponse;
import com.app.moviebooking.entity.Movie;
import com.app.moviebooking.entity.Theater;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieMapper {

    public static MovieUpdateResponse mapMovieEntityToResponse(Movie updatedMovie){
        MovieUpdateResponse movieResponse = new MovieUpdateResponse();
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

    public static MovieDetailsResponse mapEntityToDetailsResponse(Movie movie){
        MovieDetailsResponse movieResponse = new MovieDetailsResponse();
        movieResponse.setTitle(movie.getTitle());
        movieResponse.setDescription(movie.getDescription());
        movieResponse.setGenre(movie.getGenre());
        movieResponse.setLanguage(movie.getLanguage());
        movieResponse.setDuration(movie.getDuration());
        movieResponse.setReleaseDate(movie.getReleaseDate());
        List<TheaterResponse> theaters = movie.getTheaters().stream()
                .map(MovieMapper::mapTheaterToResponse)
                .collect(Collectors.toList());

        movieResponse.setTheaters(theaters);
        return movieResponse;
    }

    private static TheaterResponse mapTheaterToResponse(Theater theater) {
        TheaterResponse response = new TheaterResponse();
        response.setTheaterName(theater.getTheaterName());
        response.setLocation(theater.getLocation());
        response.setSeatCapacity(theater.getSeatCapacity());
        response.setScreenType(theater.getScreenType());
        return response;
    }
}
