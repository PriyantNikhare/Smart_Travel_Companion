package com.st.dto;

import java.time.LocalDate;

public class HotelSearchRequest {
	
    private String city;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfGuests;
    private int numberOfRooms;
    
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	
	public HotelSearchRequest(String city, LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests,
			int numberOfRooms) {
		super();
		this.city = city;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfGuests = numberOfGuests;
		this.numberOfRooms = numberOfRooms;
	}
	
	public HotelSearchRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "HotelSearchRequest [city=" + city + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
				+ ", numberOfGuests=" + numberOfGuests + ", numberOfRooms=" + numberOfRooms + "]";
	}
    
}
