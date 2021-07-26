package com.upgrad.assignment.PaymentService.entities;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transactionId")
    private int transactionId;

    @Column(name = "paymentMethod")
    private String paymentMethod;

    @Column(name = "bookingId", nullable = false)
    private int bookingId;

    @Column(name = "upiId")
    private String upiId;

    @Column(name = "cardNumber")
    private String cardNumber;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "TransactionDetailsEntity{" +
            "transactionId=" + transactionId +
            ", paymentMethod='" + paymentMethod + '\'' +
            ", bookingId=" + bookingId +
            ", upiId='" + upiId + '\'' +
            ", cardNumber='" + cardNumber + '\'' +
        '}';
    }
}
