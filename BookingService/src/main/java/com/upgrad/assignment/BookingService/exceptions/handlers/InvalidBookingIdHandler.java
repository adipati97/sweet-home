package com.upgrad.assignment.BookingService.exceptions.handlers;

import com.upgrad.assignment.BookingService.exceptions.InvalidBookingIdException;
import com.upgrad.assignment.BookingService.exceptions.responses.InvalidBookingIdResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InvalidBookingIdHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidBookingIdException.class)
    public final InvalidBookingIdResponse getExceptionResponse () {
        InvalidBookingIdException exception = getException();
        return new InvalidBookingIdResponse(
            exception.getMessage(),
            exception.getStatusCode()
        );
    }

    private InvalidBookingIdException getException () {
        return new InvalidBookingIdException(
            "Invalid Booking Id",
            HttpStatus.BAD_REQUEST.value()
        );
    }
}
