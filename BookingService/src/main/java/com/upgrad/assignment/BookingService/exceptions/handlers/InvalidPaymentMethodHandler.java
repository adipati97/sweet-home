package com.upgrad.assignment.BookingService.exceptions.handlers;

import com.upgrad.assignment.BookingService.exceptions.InvalidPaymentMethodException;
import com.upgrad.assignment.BookingService.exceptions.responses.InvalidPaymentMethodResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InvalidPaymentMethodHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidPaymentMethodException.class)
    public final InvalidPaymentMethodResponse getExceptionResponse () {
        InvalidPaymentMethodException exception = getException();
        return new InvalidPaymentMethodResponse(
            exception.getMessage(),
            exception.getStatusCode()
        );
    }

    private InvalidPaymentMethodException getException () {
        InvalidPaymentMethodException exception = new InvalidPaymentMethodException();
        exception.setMessage("Invalid mode of payment");
        exception.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return exception;
    }
}
