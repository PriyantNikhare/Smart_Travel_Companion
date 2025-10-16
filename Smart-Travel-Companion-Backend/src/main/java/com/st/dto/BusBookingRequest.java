package com.st.dto;

public class BusBookingRequest {

	private Long busId;
    private String passengerName;
    private String passengerEmail;
    private int numberOfSeats;
    
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
	
	public BusBookingRequest(Long busId, String passengerName, String passengerEmail, int numberOfSeats) {
		super();
		this.busId = busId;
		this.passengerName = passengerName;
		this.passengerEmail = passengerEmail;
		this.numberOfSeats = numberOfSeats;
	}
	
	public BusBookingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "BusBookingRequest [busId=" + busId + ", passengerName=" + passengerName + ", passengerEmail="
				+ passengerEmail + ", numberOfSeats=" + numberOfSeats + "]";
	}
    
}
