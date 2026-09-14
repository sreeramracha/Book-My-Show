package com.scaleracademy.BookMyShow.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketRequestDto {
	private int userId;
	private int showId;
	private List<Integer> seatIds;

}
