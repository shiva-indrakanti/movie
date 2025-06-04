package com.app.moviebooking.exception;

import lombok.Getter;

@Getter
public class MovieNotFoundException extends RuntimeException{
    private final String errorMessage;
    private  Long theaterId;
    private String title;

    public MovieNotFoundException(Long id, String message) {
        super(message);
        this.errorMessage = message;
        this.theaterId = id;
    }

    public MovieNotFoundException(String message , String title) {
        super(message);
        this.errorMessage = message;
        this.title = title;
    }

}
