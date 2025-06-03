package com.app.moviebooking.dto;

import com.app.moviebooking.entity.Theater;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class NewMovieRequest {
    private String title;
    private String genre;
    private String description;
    private String language;
    private Integer duration;
    private LocalDate releaseDate;
    private List<Long> theaterIds;
}
