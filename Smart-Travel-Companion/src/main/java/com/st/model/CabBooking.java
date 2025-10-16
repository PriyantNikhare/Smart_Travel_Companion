package com.st.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cab_bookings")
public class CabBooking {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cabId;
    private String riderName;
    private String riderEmail;
    private String pickupLocation;
    private String dropLocation;
    private BigDecimal estimatedDistanceKm;
    private BigDecimal totalFare;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime bookingTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public BigDecimal getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(BigDecimal totalFare) {
		this.totalFare = totalFare;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public CabBooking(Long id, Long cabId, String riderName, String riderEmail, String pickupLocation,
			String dropLocation, BigDecimal estimatedDistanceKm, BigDecimal totalFare, LocalDateTime bookingTime) {
		super();
		this.id = id;
		this.cabId = cabId;
		this.riderName = riderName;
		this.riderEmail = riderEmail;
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
		this.estimatedDistanceKm = estimatedDistanceKm;
		this.totalFare = totalFare;
		this.bookingTime = bookingTime;
	}

	public CabBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CabBooking [id=" + id + ", cabId=" + cabId + ", riderName=" + riderName + ", riderEmail=" + riderEmail
				+ ", pickupLocation=" + pickupLocation + ", dropLocation=" + dropLocation + ", estimatedDistanceKm="
				+ estimatedDistanceKm + ", totalFare=" + totalFare + ", bookingTime=" + bookingTime + "]";
	}
    
}
