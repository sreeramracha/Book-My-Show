package com.scaleracademy.BookMyShow.model;

import java.util.Date;

import com.scaleracademy.BookMyShow.model.enums.SeatStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "show_id")
	private Show show;

	@ManyToOne
	@JoinColumn(name = "seat_id")
	private Seat seat;

	@Enumerated(value = EnumType.STRING)
	private SeatStatus seatStatus;

	private Date blockedAt;
}
