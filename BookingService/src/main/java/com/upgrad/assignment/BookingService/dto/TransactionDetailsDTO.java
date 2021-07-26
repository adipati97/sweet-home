package com.upgrad.assignment.BookingService.dto;

public class TransactionDetailsDTO {
    private int transactionId;
    private String paymentMethod;
    private int bookingId;
    private String upiId;
    private String cardNumber;

    public TransactionDetailsDTO () {

    }

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
        return "{" +
            "paymentMethod='" + paymentMethod + '\'' +
            ", bookingId=" + bookingId +
            ", upiId='" + upiId + '\'' +
            ", cardNumber='" + cardNumber + '\'' +
        '}';
    }
}

