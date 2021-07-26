package com.upgrad.assignment.PaymentService.controllers;

import com.upgrad.assignment.PaymentService.dto.TransactionDetailsDTO;
import com.upgrad.assignment.PaymentService.entities.TransactionDetailsEntity;
import com.upgrad.assignment.PaymentService.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment_service")
public class TransactionDetailsController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping(
        value = "/transaction",
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity performTransaction (@RequestBody TransactionDetailsDTO transactionDetailsDTO) {
        TransactionDetailsEntity transaction = modelMapper.map(transactionDetailsDTO, TransactionDetailsEntity.class);
        TransactionDetailsDTO transactionDTO = modelMapper.map(
            transactionService.createTransaction(transaction),
            TransactionDetailsDTO.class
        );

        return new ResponseEntity(transactionDTO.getTransactionId(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/transaction/{transactionId}")
    public ResponseEntity getTransaction(@PathVariable int transactionId) {
        return new ResponseEntity(transactionService.getTransactionDetails(transactionId), HttpStatus.OK);
    }
}
