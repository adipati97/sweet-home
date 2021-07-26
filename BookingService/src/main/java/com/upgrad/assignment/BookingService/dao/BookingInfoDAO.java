package com.upgrad.assignment.BookingService.dao;

import com.upgrad.assignment.BookingService.entities.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingInfoDAO extends JpaRepository<BookingInfoEntity, Integer> {

}
