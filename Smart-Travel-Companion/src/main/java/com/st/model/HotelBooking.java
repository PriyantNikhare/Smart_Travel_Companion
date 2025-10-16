package com.st.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "hotel_bookings")
public class HotelBooking {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long hotelId;
    private String guestName;
    private String guestEmail;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfGuests;
    private int numberOfRooms;
    private BigDecimal totalPrice;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime bookingTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
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

	public HotelBooking(Long id, Long hotelId, String guestName, String guestEmail, LocalDate checkInDate,
			LocalDate checkOutDate, int numberOfGuests, int numberOfRooms, BigDecimal totalPrice,
			LocalDateTime bookingTime) {
		super();
		this.id = id;
		this.hotelId = hotelId;
		this.guestName = guestName;
		this.guestEmail = guestEmail;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfGuests = numberOfGuests;
		this.numberOfRooms = numberOfRooms;
		this.totalPrice = totalPrice;
		this.bookingTime = bookingTime;
	}

	public HotelBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HotelBooking [id=" + id + ", hotelId=" + hotelId + ", guestName=" + guestName + ", guestEmail="
				+ guestEmail + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", numberOfGuests="
				+ numberOfGuests + ", numberOfRooms=" + numberOfRooms + ", totalPrice=" + totalPrice + ", bookingTime="
				+ bookingTime + "]";
	}
    
}
