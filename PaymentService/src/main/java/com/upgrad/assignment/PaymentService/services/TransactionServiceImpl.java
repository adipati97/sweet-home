package com.upgrad.assignment.PaymentService.services;

import com.upgrad.assignment.PaymentService.dao.TransactionDetailsDAO;
import com.upgrad.assignment.PaymentService.entities.TransactionDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDetailsDAO transactionDetailsDAO;

    @Override
    public TransactionDetailsEntity createTransaction (TransactionDetailsEntity transactionDetails) {
        return transactionDetailsDAO.save(transactionDetails);
    }

    @Override
    public TransactionDetailsEntity getTransactionDetails (int id) {
        return transactionDetailsDAO.findById(id).get();
    }
}
