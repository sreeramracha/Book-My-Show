package com.scaleracademy.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaleracademy.BookMyShow.model.ShowSeat;

@Repository 
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer>{
    
}
