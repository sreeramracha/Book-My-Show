package com.scaleracademy.BookMyShow.model;

import com.scaleracademy.BookMyShow.model.enums.PaymentGateway;
import com.scaleracademy.BookMyShow.model.enums.PaymentMode;
import com.scaleracademy.BookMyShow.model.enums.PaymentStatus;

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
public class Payment extends BaseEntity {
	private double amount;

	@Enumerated(value = EnumType.STRING)
	private PaymentGateway paymentGateway;

	@Enumerated(value = EnumType.STRING)
	private PaymentStatus paymentStatus;

	@Enumerated(value = EnumType.STRING)
	private PaymentMode paymentMode;

	@ManyToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;
}
