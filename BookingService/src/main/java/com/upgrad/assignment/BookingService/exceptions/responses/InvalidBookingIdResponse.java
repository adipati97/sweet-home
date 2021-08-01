package com.upgrad.assignment.BookingService.exceptions.responses;

import com.upgrad.assignment.BookingService.exceptions.templates.ResponseTemplate;

public class InvalidBookingIdResponse extends ResponseTemplate {
    public InvalidBookingIdResponse (String message, int statusCode) {
        setMessage(message);
        setStatusCode(statusCode);
    }
}
