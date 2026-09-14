package com.scaleracademy.BookMyShow.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Theater extends BaseEntity {
	private String name;

	@ManyToOne
	@JoinColumn(name = "region_id")
	private Region region;

	@OneToMany(mappedBy = "theater")
	private List<Screen> screens;
}
