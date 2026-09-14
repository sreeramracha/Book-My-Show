package com.scaleracademy.BookMyShow.model;

import java.util.Date;
import java.util.List;

import com.scaleracademy.BookMyShow.model.enums.Feature;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseEntity{
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;

	private Date startTime;
	private Date endTime;

	@ManyToOne
	@JoinColumn(name = "screen_id")
	private Screen screen;

	@ElementCollection
	private List<Feature> faetures;
}
