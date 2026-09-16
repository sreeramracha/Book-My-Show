package com.scaleracademy.BookMyShow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scaleracademy.BookMyShow.model.Show;
import com.scaleracademy.BookMyShow.model.ShowSeat;

@Service 
public class PriceCalculator {
    public double calculatorPrice(Show show, List<ShowSeat> showSeats){
        return 100;
    }
}
