package com.scaleracademy.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaleracademy.BookMyShow.dto.BookTicketRequestDto;
import com.scaleracademy.BookMyShow.dto.BookTicketResponseDto;
import com.scaleracademy.BookMyShow.model.Booking;
import com.scaleracademy.BookMyShow.model.enums.ResponseStatus;
import com.scaleracademy.BookMyShow.service.BookingService;


@Controller
public class BookingController {

	private BookingService ticketService;

	@Autowired
	public BookingController(BookingService ticketService) {
		this.ticketService = ticketService;
	}

	public BookTicketResponseDto bookTicket(BookTicketRequestDto request) {
		BookTicketResponseDto response=new BookTicketResponseDto();

		try {
			Booking ticket = ticketService.bookTicket(request.getUserId(), request.getShowId(), request.getSeatIds());
			response.setBookingId(ticket.getTicketNumber());
			response.setAmount(ticket.getAmount());
			response.setStatus(ResponseStatus.SUCCESS);
		} catch (Exception e) {
			response.setStatus(ResponseStatus.FAILURE);
		}

		return response;

	}
}
