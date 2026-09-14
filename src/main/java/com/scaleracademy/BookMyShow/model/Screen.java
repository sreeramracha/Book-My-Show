package com.scaleracademy.BookMyShow.model;

import java.util.List;

import com.scaleracademy.BookMyShow.model.enums.Feature;
import com.scaleracademy.BookMyShow.model.enums.ScreenStatus;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Screen extends BaseEntity {

	private String name;

	@ManyToMany
	private List<Seat> seats;

	@ElementCollection
	private List<Feature> features;

	@Enumerated(value = EnumType.STRING)
	private ScreenStatus status;

	@ManyToOne
	@JoinColumn(name = "theater_id")
	private Theater theater;
}
