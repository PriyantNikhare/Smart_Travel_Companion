package com.st.dto;

import java.time.LocalDate;

public class FlightSearchRequest {

	private String origin;
    private String destination;
    private LocalDate departureDate;
    private int seats;
    
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public FlightSearchRequest(String origin, String destination, LocalDate departureDate, int seats) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.seats = seats;
	}
	
	public FlightSearchRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "SearchRequest [origin=" + origin + ", destination=" + destination + ", departureDate=" + departureDate
				+ ", seats=" + seats + "]";
	}

}
