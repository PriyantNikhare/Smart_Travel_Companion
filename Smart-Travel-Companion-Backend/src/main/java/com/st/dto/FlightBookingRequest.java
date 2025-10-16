package com.st.dto;

public class FlightBookingRequest {

	private Long flightId;
    private String passengerName;
    private String passengerEmail;
    private int numberOfTravelers;
    
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
	
	public FlightBookingRequest(Long flightId, String passengerName, String passengerEmail, int numberOfTravelers) {
		super();
		this.flightId = flightId;
		this.passengerName = passengerName;
		this.passengerEmail = passengerEmail;
		this.numberOfTravelers = numberOfTravelers;
	}
	
	public FlightBookingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "BookingRequest [flightId=" + flightId + ", passengerName=" + passengerName + ", passengerEmail="
				+ passengerEmail + ", numberOfTravelers=" + numberOfTravelers + "]";
	}

}
