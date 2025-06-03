package com.app.moviebooking.exception;

import java.util.List;

public class TheaterNotFoundException extends RuntimeException{
    private  List<Long> theaterIds;
    private  String errorMessage;
    private  Long theaterId;

    public TheaterNotFoundException(List<Long> theaterIds, String message) {
        super(message);
        this.theaterIds = theaterIds;
        this.errorMessage = message;
    }

    public TheaterNotFoundException(Long id, String message) {
        super(message);
        this.errorMessage = message;
        this.theaterId = id;
    }

    public List<Long> getTheaterIds() {
        return theaterIds;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Long getTheaterId() {
        return theaterId;
    }
}
