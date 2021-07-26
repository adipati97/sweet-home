package com.upgrad.assignment.BookingService.services;

import com.upgrad.assignment.BookingService.dao.BookingInfoDAO;
import com.upgrad.assignment.BookingService.dto.TransactionDetailsDTO;
import com.upgrad.assignment.BookingService.entities.BookingInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        BookingInfoEntity bookingInfo = bookingInfoDAO.findById(bookingId).get();
        int transactionId = getTransactionId(transactionDetails);
        bookingInfo.setTransactionId(transactionId);
        return bookingInfo;
    }

    private int getTransactionId (TransactionDetailsDTO transactionDetails) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TransactionDetailsDTO> request = new HttpEntity<>(transactionDetails, headers);
        return restTemplate.postForObject(paymentServiceUrl + "/transaction", request, Integer.class);
    }
}
