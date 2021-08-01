package com.upgrad.assignment.BookingService.exceptions;

import com.upgrad.assignment.BookingService.exceptions.templates.ExceptionTemplate;

public class InvalidBookingIdException extends ExceptionTemplate {
    public InvalidBookingIdException (String message, int statusCode) {
        setMessage(message);
        setStatusCode(statusCode);
    }
}
