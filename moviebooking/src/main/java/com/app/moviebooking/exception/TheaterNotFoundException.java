package com.app.moviebooking.exception;

import java.util.List;

public class TheaterNotFoundException extends RuntimeException{
    private final List<Long> theaterIds;
    private final String errorMessage;

    public TheaterNotFoundException(List<Long> theaterIds, String message) {
        super(message);
        this.theaterIds = theaterIds;
        this.errorMessage = message;
    }

    public List<Long> getTheaterIds() {
        return theaterIds;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
