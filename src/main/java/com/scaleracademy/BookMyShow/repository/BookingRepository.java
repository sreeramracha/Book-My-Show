package com.scaleracademy.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaleracademy.BookMyShow.model.Booking;

@Repository 
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    
}
