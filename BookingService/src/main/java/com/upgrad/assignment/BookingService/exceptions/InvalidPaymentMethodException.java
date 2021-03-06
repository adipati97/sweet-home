package com.upgrad.assignment.BookingService.exceptions;

import com.upgrad.assignment.BookingService.exceptions.templates.ExceptionTemplate;

public class InvalidPaymentMethodException extends ExceptionTemplate {
    public InvalidPaymentMethodException (String message, int statusCode) {
        setMessage(message);
        setStatusCode(statusCode);
    }
}
