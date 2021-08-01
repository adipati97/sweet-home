package com.upgrad.assignment.BookingService.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class BookingInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookingId")
    private int id;

    @Column(name = "fromDate")
    private Date fromDate;

    @Column(name = "toDate")
    private Date toDate;

    @Column(name = "aadharNumber")
    private String aadharNumber;

    @Column(name = "numOfRooms")
    private int numOfRooms;

    @Column(name = "roomNumbers")
    private String roomNumbers;

    @Column(name = "roomPrice", nullable = false)
    private int roomPrice;

    @Column(name = "transactionId")
    private int transactionId = 0;

    @Column(name = "bookedOn")
    private Date bookedOn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    @JsonIgnore
    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public String getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(String roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(Date bookedOn) {
        this.bookedOn = bookedOn;
    }

    @Override
    public String toString() {
        return "BookingInfoEntity{" +
            "id=" + id +
            ", fromDate=" + fromDate +
            ", toDate=" + toDate +
            ", aadharNumber='" + aadharNumber + '\'' +
            ", roomNumbers='" + roomNumbers + '\'' +
            ", roomPrice=" + roomPrice +
            ", transactionId=" + transactionId +
            ", bookedOn=" + bookedOn +
        '}';
    }
}
