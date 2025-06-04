package com.app.moviebooking.dto.response;

import com.app.moviebooking.entity.Theater;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MovieUpdateResponse {
    private String title;
    private String genre;
    private String description;
    private String language;
    private Integer duration;
    private LocalDate releaseDate;
    private List<Long> theaterIds;
}
