package com.st.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "hotels")
public class Hotel {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelName;
    private String city;
    private String address;
    private int rating;
    private BigDecimal pricePerNight;
    private String amenities;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public BigDecimal getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(BigDecimal pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public String getAmenities() {
		return amenities;
	}
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}
	
	public Hotel(Long id, String hotelName, String city, String address, int rating, BigDecimal pricePerNight,
			String amenities) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.city = city;
		this.address = address;
		this.rating = rating;
		this.pricePerNight = pricePerNight;
		this.amenities = amenities;
	}
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", hotelName=" + hotelName + ", city=" + city + ", address=" + address + ", rating="
				+ rating + ", pricePerNight=" + pricePerNight + ", amenities=" + amenities + "]";
	}
    
}
