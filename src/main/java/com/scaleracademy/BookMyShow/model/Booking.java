package com.scaleracademy.BookMyShow.model;

import java.util.List;

import com.scaleracademy.BookMyShow.model.enums.BookingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Booking extends BaseEntity {
	private String ticketNumber;

	@Enumerated(value = EnumType.STRING)
	private BookingStatus ticketStatus;

	private double amount;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany
	@JoinTable
	private List<ShowSeat> bookedShowSeats;

	@ManyToOne
	@JoinColumn(name = "show_id")
	private Show show;

	@OneToMany(mappedBy = "ticket")
	private List<Payment> payments;


}
