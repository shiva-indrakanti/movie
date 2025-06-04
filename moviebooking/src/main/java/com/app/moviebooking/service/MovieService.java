package com.app.moviebooking.service;

import com.app.moviebooking.dto.NewMovieRequest;
import com.app.moviebooking.dto.response.MovieDetailsResponse;
import com.app.moviebooking.dto.response.MovieUpdateResponse;
import com.app.moviebooking.entity.Movie;
import com.app.moviebooking.entity.Theater;
import com.app.moviebooking.exception.MovieNotFoundException;
import com.app.moviebooking.exception.TheaterNotFoundException;
import com.app.moviebooking.mapper.MovieMapper;
import com.app.moviebooking.repo.MovieRepo;
import com.app.moviebooking.repo.TheaterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
            List<Long> foundTheatersIds = theaterList.stream().map(Theater::getId).toList();
            List<Long> missingTheaters = requestedIds.stream().filter(id -> !foundTheatersIds.contains(id)).toList();
            throw new TheaterNotFoundException(missingTheaters,"Theater lookup failed: some IDs provided do not exist.");
        }
        movieEntity.setTheaters(theaterList);

        for (Theater theater : theaterList) {
            theater.getMovies().add(movieEntity);
        }

        movieRepo.save(movieEntity);
        return "Movie has been added successfully";
    }

    public MovieUpdateResponse updateMovie(Long movieId, NewMovieRequest request) {
        Movie movie = movieRepo.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(movieId ,"Movie not found with ID "));

        movie.setTitle(request.getTitle());
        movie.setGenre(request.getGenre());
        movie.setDescription(request.getDescription());
        movie.setLanguage(request.getLanguage());
        movie.setDuration(request.getDuration());
        movie.setReleaseDate(request.getReleaseDate());

        List<Long> requestedIds = request.getTheaterIds();
        List<Theater> theaterList = theaterRepo.findAllById(request.getTheaterIds());
        if(requestedIds.size() != theaterList.size()){
            List<Long> foundTheaters = theaterList.stream().map(Theater::getId).toList();
            List<Long> missingTheaters = requestedIds.stream().filter(id -> !foundTheaters.contains(id)).toList();
            throw new TheaterNotFoundException(missingTheaters,"Theater lookup failed: some IDs provided do not exist.");
        }
        movie.setTheaters(theaterList);

        for (Theater theater : theaterList) {
            theater.getMovies().add(movie);
        }
        Movie updatedMovie = movieRepo.save(movie);
        return MovieMapper.mapMovieEntityToResponse(updatedMovie);
    }

    public String removeMovie(Long movieId) {

        Movie movie = movieRepo.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(movieId ,"Movie not found with ID "));

        for (Theater theater : movie.getTheaters()) {
            theater.getMovies().remove(movie);
        }

        movie.setTheaters(Collections.emptyList());
        movieRepo.delete(movie);
        return "Successfully deleted a movie";
    }

    public MovieDetailsResponse retrieveMovie(String title){
        Movie movie = movieRepo.findByTitle(title).orElseThrow(() -> new MovieNotFoundException("Movie Not found","title"));

        if(movie.getTheaters().isEmpty()){
            throw new TheaterNotFoundException("No Theaters found for particular movie ="+title);
        }

        return MovieMapper.mapEntityToDetailsResponse(movie);
    }
}
