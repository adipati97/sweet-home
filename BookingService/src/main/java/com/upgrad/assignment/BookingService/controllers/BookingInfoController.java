package com.upgrad.assignment.BookingService.controllers;

import com.upgrad.assignment.BookingService.dto.BookingInfoDTO;
import com.upgrad.assignment.BookingService.dto.TransactionDetailsDTO;
import com.upgrad.assignment.BookingService.entities.BookingInfoEntity;
import com.upgrad.assignment.BookingService.exceptions.handlers.InvalidPaymentMethodHandler;
import com.upgrad.assignment.BookingService.services.BookingInfoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/booking_service")
public class BookingInfoController {
    private static String PAYMENT_MODE_CARD = "CARD";
    private static String PAYMENT_MODE_UPI = "UPI";
    @Autowired
    private BookingInfoService bookingInfoService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping(
        value = "/booking",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity bookRooms (@RequestBody BookingInfoDTO bookingInfoDTO) {
        //Convert DTO to Entity
        BookingInfoEntity newBooking = modelMapper.map(bookingInfoDTO, BookingInfoEntity.class);

        //Perform required calculations and create new booking
        setRoomNumbers(newBooking);
        setTotalPrice(newBooking);
        newBooking.setBookedOn(new Date());
        BookingInfoEntity newBookingInfo = bookingInfoService.acceptBookingDetails(newBooking);

        return new ResponseEntity(newBookingInfo, HttpStatus.CREATED);
    }

    private void setRoomNumbers (BookingInfoEntity bookingInfo) {
        int upperBound = 100;
        Random roomNumberGenerator = new Random();
        List<String> roomNumbers = new ArrayList<String>();

        for (int i = 0; i < bookingInfo.getNumOfRooms(); i++) {
            roomNumbers.add(String.valueOf(roomNumberGenerator.nextInt(upperBound)));
        }

        bookingInfo.setRoomNumbers(String.join(",", roomNumbers));
    }

    private void setTotalPrice (BookingInfoEntity bookingInfo) {
        int pricePerRoomPerDay = 1000;
        int numOfDays = getNumOfDays(bookingInfo.getFromDate(), bookingInfo.getToDate());

        bookingInfo.setRoomPrice(pricePerRoomPerDay * bookingInfo.getNumOfRooms() * numOfDays);
    }

    private int getNumOfDays (Date fromDate, Date toDate) {
        return (int) ChronoUnit.DAYS.between(fromDate.toInstant(), toDate.toInstant());
    }

    @PostMapping(
        value = "/booking/{bookingId}/transaction",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity getBookingDetails (
        @RequestBody TransactionDetailsDTO transactionDetails,
        @PathVariable int bookingId
    ) {
        //check whether payment mode is either CARD or UPI
        if (!getIsValidPaymentMethod(transactionDetails.getPaymentMethod())) {
            return new ResponseEntity(
                new InvalidPaymentMethodHandler().getExceptionResponse(), HttpStatus.BAD_REQUEST);
        }

        BookingInfoEntity bookingInfo = bookingInfoService.getBookingInfo(transactionDetails, bookingId);
        BookingInfoDTO bookingInfoDTO = modelMapper.map(bookingInfo, BookingInfoDTO.class);
        return new ResponseEntity(bookingInfoDTO, HttpStatus.CREATED);
    }

    private boolean getIsValidPaymentMethod (String paymentMethod) {
        return paymentMethod.equalsIgnoreCase(PAYMENT_MODE_CARD) || paymentMethod.equalsIgnoreCase(PAYMENT_MODE_UPI);
    }
}
