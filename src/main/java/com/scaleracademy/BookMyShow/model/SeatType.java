package com.scaleracademy.BookMyShow.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SeatType extends BaseEntity {
	private String name;

}
