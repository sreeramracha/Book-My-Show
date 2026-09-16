package com.scaleracademy.BookMyShow.service;

import java.sql.Date;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.scaleracademy.BookMyShow.exception.SeatCountException;
import com.scaleracademy.BookMyShow.exception.ShowNotFoundException;
import com.scaleracademy.BookMyShow.exception.UserNotFoundException;
import com.scaleracademy.BookMyShow.model.Booking;
import com.scaleracademy.BookMyShow.model.Show;
import com.scaleracademy.BookMyShow.model.ShowSeat;
import com.scaleracademy.BookMyShow.model.User;
import com.scaleracademy.BookMyShow.model.enums.BookingStatus;
import com.scaleracademy.BookMyShow.model.enums.SeatStatus;
import com.scaleracademy.BookMyShow.repository.BookingRepository;
import com.scaleracademy.BookMyShow.repository.ShowRepository;
import com.scaleracademy.BookMyShow.repository.ShowSeatRepository;
import com.scaleracademy.BookMyShow.repository.UserRepository;

@Service
public class BookingService {
	private UserRepository userRepository;
	private ShowRepository showRepository;
	private ShowSeatRepository showSeatRepository;
	private PriceCalculator priceCalculator;
	private BookingRepository bookingRepository;
	private final static int MAX_SEAT_COUNT = 10;

	@Autowired 
	public BookingService(UserRepository userRepository, ShowRepository showRepository,
            ShowSeatRepository showSeatRepository, PriceCalculator priceCalculator,
		 BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
		this.priceCalculator = priceCalculator;
		 this.bookingRepository = bookingRepository;
    }

	@Transactional(isolation=Isolation.SERIALIZABLE)
    public Booking bookTicket(int userId, int showId, List<Integer> showSeatIds) {

		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("invalid user id"));
		Show show = showRepository.findById(showId).orElseThrow(() -> new ShowNotFoundException("invalid show id"));
		
		if (showSeatIds.size()> MAX_SEAT_COUNT){
			throw new SeatCountException("maximum seat count exceeded");
		}

		List<ShowSeat> bookedShowSeats=showSeatRepository.findAllById(showSeatIds);
		for(ShowSeat showSeat:bookedShowSeats){
			boolean isAvailable=showSeat.getSeatStatus().equals(SeatStatus.EMPTY);
			boolean isExpired=showSeat.getSeatStatus().equals(SeatStatus.BLOCKED) && Duration.between(new Date().toInstant(), showSeat.getBlockedAt().toInstant()).toMinutes()>15;
			
			if(!(isAvailable || isExpired)){
				throw new RuntimeException( "Seat already blocked");
			}
		}

		// SOFT BLOCK SEATS
		List<ShowSeat> savedShowSeats=new ArrayList<>();
		for(ShowSeat showSeat: bookedShowSeats){
			showSeat.setSeatStatus(SeatStatus.BLOCKED);
			showSeat.setBlockedAt(new Date());
			savedShowSeats.add(showSeatRepository.save(showSeat));
		}

		// Create Booking
		Booking booking=new Booking();
		booking.setTicketNumber(String.valueOf(UUID.randomUUID()));
		booking.setTicketStatus(BookingStatus.PENDING);
		booking.setAmount(priceCalculator.calculatorPrice(show, savedShowSeats));
		booking.setUser(user);
		booking.setBookedShowSeats(bookedShowSeats);
		booking.setShow(show);
		booking.setPayments(new ArrayList<>());

		return bookingRepository.save(booking);
	}
}
