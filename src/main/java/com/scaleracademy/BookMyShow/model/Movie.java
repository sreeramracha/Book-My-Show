package com.scaleracademy.BookMyShow.model;

import java.util.List;

import com.scaleracademy.BookMyShow.model.enums.Feature;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie extends BaseEntity {
	private String title;

	@ElementCollection
	private List<String> cast;

	private String genre;

	@ElementCollection
	private List<String> languages;

	@ElementCollection
	private List<Feature> features;

	private String description;
	private int rating;
}
