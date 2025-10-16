package com.st.dto;

import java.time.LocalDate;

public class HotelBookingRequest {
	
    private Long hotelId;
    private String guestName;
    private String guestEmail;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfGuests;
    private int numberOfRooms;
    
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
	
	public HotelBookingRequest(Long hotelId, String guestName, String guestEmail, LocalDate checkInDate,
			LocalDate checkOutDate, int numberOfGuests, int numberOfRooms) {
		super();
		this.hotelId = hotelId;
		this.guestName = guestName;
		this.guestEmail = guestEmail;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfGuests = numberOfGuests;
		this.numberOfRooms = numberOfRooms;
	}
	
	public HotelBookingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "HotelBookingRequest [hotelId=" + hotelId + ", guestName=" + guestName + ", guestEmail=" + guestEmail
				+ ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", numberOfGuests="
				+ numberOfGuests + ", numberOfRooms=" + numberOfRooms + "]";
	}

}
