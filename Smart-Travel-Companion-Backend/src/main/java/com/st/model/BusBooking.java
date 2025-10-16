package com.st.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bus_bookings")
public class BusBooking {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long busId;
    private String passengerName;
    private String passengerEmail;
    private int numberOfSeats;
    private BigDecimal totalPrice;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime bookingTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public BusBooking(Long id, Long busId, String passengerName, String passengerEmail, int numberOfSeats,
			BigDecimal totalPrice, LocalDateTime bookingTime) {
		super();
		this.id = id;
		this.busId = busId;
		this.passengerName = passengerName;
		this.passengerEmail = passengerEmail;
		this.numberOfSeats = numberOfSeats;
		this.totalPrice = totalPrice;
		this.bookingTime = bookingTime;
	}

	public BusBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BusBooking [id=" + id + ", busId=" + busId + ", passengerName=" + passengerName + ", passengerEmail="
				+ passengerEmail + ", numberOfSeats=" + numberOfSeats + ", totalPrice=" + totalPrice + ", bookingTime="
				+ bookingTime + "]";
	}
    
}

