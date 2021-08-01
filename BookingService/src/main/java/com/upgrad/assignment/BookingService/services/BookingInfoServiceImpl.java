package com.upgrad.assignment.BookingService.services;

import com.upgrad.assignment.BookingService.dao.BookingInfoDAO;
import com.upgrad.assignment.BookingService.dto.TransactionDetailsDTO;
import com.upgrad.assignment.BookingService.entities.BookingInfoEntity;
import com.upgrad.assignment.BookingService.exceptions.InvalidBookingIdException;
import com.upgrad.assignment.BookingService.exceptions.handlers.InvalidBookingIdHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BookingInfoServiceImpl implements BookingInfoService{
    @Value("${paymentService.url}")
    private String paymentServiceUrl;

    @Autowired
    private BookingInfoDAO bookingInfoDAO;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public BookingInfoEntity acceptBookingDetails(BookingInfoEntity bookingInfo) {
        return bookingInfoDAO.save(bookingInfo);
    }

    @Override
    public BookingInfoEntity getBookingInfo(TransactionDetailsDTO transactionDetails, int bookingId) {
        Optional<BookingInfoEntity> bookingInfo = bookingInfoDAO.findById(bookingId);
        if (bookingInfo.isEmpty()) {
            throw new InvalidBookingIdException(
                "Invalid Booking Id",
                HttpStatus.BAD_REQUEST.value()
            );
        }
        int transactionId = getTransactionId(transactionDetails);
        bookingInfo.get().setTransactionId(transactionId);
        return bookingInfo.get();
    }

    private int getTransactionId (TransactionDetailsDTO transactionDetails) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TransactionDetailsDTO> request = new HttpEntity<>(transactionDetails, headers);
        return restTemplate.postForObject(paymentServiceUrl + "/transaction", request, Integer.class);
    }
}
