package com.upgrad.assignment.BookingService.services;

import com.upgrad.assignment.BookingService.dto.TransactionDetailsDTO;
import com.upgrad.assignment.BookingService.entities.BookingInfoEntity;

public interface BookingInfoService {
    public BookingInfoEntity acceptBookingDetails (BookingInfoEntity bookingInfo);
    public BookingInfoEntity getBookingInfo (TransactionDetailsDTO transactionDetails, int bookingId);
}
