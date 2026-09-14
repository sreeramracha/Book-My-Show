package com.scaleracademy.BookMyShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaleracademy.BookMyShow.exception.UserNotFoundException;
import com.scaleracademy.BookMyShow.model.Show;
import com.scaleracademy.BookMyShow.model.Ticket;
import com.scaleracademy.BookMyShow.model.User;
import com.scaleracademy.BookMyShow.repository.ShowRepository;
import com.scaleracademy.BookMyShow.repository.UserRepository;

@Service
public class TicketService {
	private UserRepository userRepository;
	private ShowRepository showRepository;

	@Autowired
	public TicketService() {
		this.userRepository = userRepository;
		this.showRepository = showRepository;
	}

	public Ticket bookTicket(int userId, int showId, List<Integer> showSeatIds) {

		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("invalid user id"));
		Show show = showRepository.findById(showId).orElseThrow();
		return null;
	}
}
