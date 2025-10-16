package com.st.dto;

import java.time.LocalDate;

public class TrainSearchRequest {
	
    private String fromStation;
    private String toStation;
    private LocalDate journeyDate;
    private int passengers;
    
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	public LocalDate getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	
	public TrainSearchRequest(String fromStation, String toStation, LocalDate journeyDate, int passengers) {
		super();
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.journeyDate = journeyDate;
		this.passengers = passengers;
	}
	
	public TrainSearchRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "TrainSearchRequest [fromStation=" + fromStation + ", toStation=" + toStation + ", journeyDate="
				+ journeyDate + ", passengers=" + passengers + "]";
	}
    
}
