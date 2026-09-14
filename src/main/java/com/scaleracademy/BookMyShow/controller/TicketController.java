package com.scaleracademy.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaleracademy.BookMyShow.dto.BookTicketRequestDto;
import com.scaleracademy.BookMyShow.dto.BookTicketResponseDto;
import com.scaleracademy.BookMyShow.model.Ticket;
import com.scaleracademy.BookMyShow.model.enums.ResponseStatus;
import com.scaleracademy.BookMyShow.service.TicketService;


@Controller
public class TicketController {

	private TicketService ticketService;

	@Autowired
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	public BookTicketResponseDto bookTicket(BookTicketRequestDto request) {
		BookTicketResponseDto response=new BookTicketResponseDto();

		try {
			Ticket ticket = ticketService.bookTicket(request.getUserId(), request.getShowId(), request.getSeatIds());
			response.setBookingId(ticket.getTicketNumber());
			response.setAmount(ticket.getAmount());
			response.setStatus(ResponseStatus.SUCCESS);
		} catch (Exception e) {
			response.setStatus(ResponseStatus.FAILURE);
		}

		return response;

	}
}
