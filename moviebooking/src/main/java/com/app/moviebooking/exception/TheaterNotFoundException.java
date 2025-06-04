package com.app.moviebooking.exception;

import java.util.List;

public class TheaterNotFoundException extends RuntimeException{
    private  List<Long> theaterIds;
    private  String errorMessage;

    public TheaterNotFoundException(List<Long> theaterIds, String message) {
        super(message);
        this.theaterIds = theaterIds;
        this.errorMessage = message;
    }

    public TheaterNotFoundException(String message) {
        this.errorMessage = message;
    }

    public List<Long> getTheaterIds() {
        return theaterIds;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
