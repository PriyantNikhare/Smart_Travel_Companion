package com.st.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flight_bookings")
public class FlightBooking {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long flightId;
    private String passengerName;
    private String passengerEmail;
    private int numberOfTravelers;
    private BigDecimal totalPrice;
    
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime bookingTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
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

	public int getNumberOfTravelers() {
		return numberOfTravelers;
	}

	public void setNumberOfTravelers(int numberOfTravelers) {
		this.numberOfTravelers = numberOfTravelers;
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

	public FlightBooking(Long id, Long flightId, String passengerName, String passengerEmail, int numberOfTravelers,
			BigDecimal totalPrice, LocalDateTime bookingTime) {
		super();
		this.id = id;
		this.flightId = flightId;
		this.passengerName = passengerName;
		this.passengerEmail = passengerEmail;
		this.numberOfTravelers = numberOfTravelers;
		this.totalPrice = totalPrice;
		this.bookingTime = bookingTime;
	}

	public FlightBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", flightId=" + flightId + ", passengerName=" + passengerName + ", passengerEmail="
				+ passengerEmail + ", numberOfTravelers=" + numberOfTravelers + ", totalPrice=" + totalPrice
				+ ", bookingTime=" + bookingTime + "]";
	}
    
}
