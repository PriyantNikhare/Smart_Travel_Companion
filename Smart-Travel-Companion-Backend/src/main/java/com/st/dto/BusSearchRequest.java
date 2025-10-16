package com.st.dto;

import java.time.LocalDate;

public class BusSearchRequest {

	private String fromCity;
    private String toCity;
    private LocalDate travelDate;
    private int seats;
    
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public BusSearchRequest(String fromCity, String toCity, LocalDate travelDate, int seats) {
		super();
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.travelDate = travelDate;
		this.seats = seats;
	}
	
	public BusSearchRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "BusSearchRequest [fromCity=" + fromCity + ", toCity=" + toCity + ", travelDate=" + travelDate
				+ ", seats=" + seats + "]";
	}
    
}
