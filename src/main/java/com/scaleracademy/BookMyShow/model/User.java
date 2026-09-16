package com.scaleracademy.BookMyShow.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "users")
public class User extends BaseEntity {
	private String email;
	private String name;
	private String mobileNumber;
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Booking> tickets;
}
