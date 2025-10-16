package com.st.dto;

import java.time.LocalDate;

public class TripRequest {
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private double budget;
    private String preferences;
    private Long userId;

    public TripRequest() {}

    public TripRequest(String destination, LocalDate startDate, LocalDate endDate, double budget, String preferences, Long userId) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.preferences = preferences;
        this.userId = userId;
    }

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getPreferences() {
		return preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}

    
