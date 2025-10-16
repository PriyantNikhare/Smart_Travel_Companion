package com.st.dto;

public class TrainBookingRequest {
	
    private Long trainId;
    private String passengerName;
    private String passengerEmail;
    private int numberOfPassengers;
    
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
	
	public TrainBookingRequest(Long trainId, String passengerName, String passengerEmail, int numberOfPassengers) {
		super();
		this.trainId = trainId;
		this.passengerName = passengerName;
		this.passengerEmail = passengerEmail;
		this.numberOfPassengers = numberOfPassengers;
	}
	
	public TrainBookingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "TrainBookingRequest [trainId=" + trainId + ", passengerName=" + passengerName + ", passengerEmail="
				+ passengerEmail + ", numberOfPassengers=" + numberOfPassengers + "]";
	}
    
}
