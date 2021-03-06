package com.upgrad.assignment.BookingService.exceptions.responses;

import com.upgrad.assignment.BookingService.exceptions.templates.ResponseTemplate;

public class InvalidPaymentMethodResponse extends ResponseTemplate {
    public InvalidPaymentMethodResponse (String message, int statusCode) {
        setMessage(message);
        setStatusCode(statusCode);
    }
}
