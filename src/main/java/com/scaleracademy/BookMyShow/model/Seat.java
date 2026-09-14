package com.scaleracademy.BookMyShow.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseEntity {
	private String seatNumber;
	private int rowVal;
	private int columnVal;

	@ManyToOne
	@JoinColumn(name = "seat_type_id")
	private SeatType seatType;
}
