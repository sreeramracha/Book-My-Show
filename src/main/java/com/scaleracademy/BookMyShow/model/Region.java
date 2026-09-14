package com.scaleracademy.BookMyShow.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Region extends BaseEntity {
	private String name;

	@OneToMany(mappedBy = "region")
	private List<Theater> theaters;

}
