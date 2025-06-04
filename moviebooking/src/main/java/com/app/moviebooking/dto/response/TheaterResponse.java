package com.app.moviebooking.dto.response;

import lombok.Data;

@Data
public class TheaterResponse {
    private String theaterName;

    private String location;

    private int seatCapacity;

    private String screenType;
}
