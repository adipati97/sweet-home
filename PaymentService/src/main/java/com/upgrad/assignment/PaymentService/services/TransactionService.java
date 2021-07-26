package com.upgrad.assignment.PaymentService.services;

import com.upgrad.assignment.PaymentService.entities.TransactionDetailsEntity;

public interface TransactionService {
    public TransactionDetailsEntity createTransaction(TransactionDetailsEntity transactionDetails);
    public TransactionDetailsEntity getTransactionDetails(int id);
}
