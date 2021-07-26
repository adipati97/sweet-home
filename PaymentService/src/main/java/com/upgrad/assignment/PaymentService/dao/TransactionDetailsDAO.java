package com.upgrad.assignment.PaymentService.dao;

import com.upgrad.assignment.PaymentService.entities.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailsDAO extends JpaRepository<TransactionDetailsEntity, Integer> {

}
