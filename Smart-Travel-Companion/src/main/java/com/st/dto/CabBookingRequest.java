package com.st.dto;

import java.math.BigDecimal;

public class CabBookingRequest {
	
    private Long cabId;
    private String riderName;
    private String riderEmail;
    private String pickupLocation;
    private String dropLocation;
    private BigDecimal estimatedDistanceKm;
    
	public Long getCabId() {
		return cabId;
	}
	public void setCabId(Long cabId) {
		this.cabId = cabId;
	}
	public String getRiderName() {
		return riderName;
	}
	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}
	public String getRiderEmail() {
		return riderEmail;
	}
	public void setRiderEmail(String riderEmail) {
		this.riderEmail = riderEmail;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
	public BigDecimal getEstimatedDistanceKm() {
		return estimatedDistanceKm;
	}
	public void setEstimatedDistanceKm(BigDecimal estimatedDistanceKm) {
		this.estimatedDistanceKm = estimatedDistanceKm;
	}
	
	public CabBookingRequest(Long cabId, String riderName, String riderEmail, String pickupLocation,
			String dropLocation, BigDecimal estimatedDistanceKm) {
		super();
		this.cabId = cabId;
		this.riderName = riderName;
		this.riderEmail = riderEmail;
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
		this.estimatedDistanceKm = estimatedDistanceKm;
	}
	
	public CabBookingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "CabBookingRequest [cabId=" + cabId + ", riderName=" + riderName + ", riderEmail=" + riderEmail
				+ ", pickupLocation=" + pickupLocation + ", dropLocation=" + dropLocation + ", estimatedDistanceKm="
				+ estimatedDistanceKm + "]";
	}
    
}
