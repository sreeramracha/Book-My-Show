package com.scaleracademy.BookMyShow.dto;

import com.scaleracademy.BookMyShow.model.enums.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {
	private String bookingId;
	private double amount;
	private ResponseStatus status;
}
