package com.st.dto;

public class CabSearchRequest {
	
    private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public CabSearchRequest(String city) {
		super();
		this.city = city;
	}

	public CabSearchRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CabSearchRequest [city=" + city + "]";
	}
    
}