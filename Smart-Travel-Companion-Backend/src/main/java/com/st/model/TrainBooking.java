package com.st.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "train_bookings")
public class TrainBooking {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long trainId;
    private String passengerName;
    private String passengerEmail;
    private int numberOfPassengers;
    private BigDecimal totalPrice;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime bookingTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTrainId() {
		return trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
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

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
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

	public TrainBooking(Long id, Long trainId, String passengerName, String passengerEmail, int numberOfPassengers,
			BigDecimal totalPrice, LocalDateTime bookingTime) {
		super();
		this.id = id;
		this.trainId = trainId;
		this.passengerName = passengerName;
		this.passengerEmail = passengerEmail;
		this.numberOfPassengers = numberOfPassengers;
		this.totalPrice = totalPrice;
		this.bookingTime = bookingTime;
	}

	public TrainBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TrainBooking [id=" + id + ", trainId=" + trainId + ", passengerName=" + passengerName
				+ ", passengerEmail=" + passengerEmail + ", numberOfPassengers=" + numberOfPassengers + ", totalPrice="
				+ totalPrice + ", bookingTime=" + bookingTime + "]";
	}
    
}
