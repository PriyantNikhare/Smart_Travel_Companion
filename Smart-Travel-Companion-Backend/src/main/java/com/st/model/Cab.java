package com.st.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cabs")
public class Cab {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String driverName;
    private String cabType;
    private BigDecimal ratePerKm;
    private String city;
    private boolean isAvailable;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getCabType() {
		return cabType;
	}
	public void setCabType(String cabType) {
		this.cabType = cabType;
	}
	public BigDecimal getRatePerKm() {
		return ratePerKm;
	}
	public void setRatePerKm(BigDecimal ratePerKm) {
		this.ratePerKm = ratePerKm;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public Cab(Long id, String driverName, String cabType, BigDecimal ratePerKm, String city, boolean isAvailable) {
		super();
		this.id = id;
		this.driverName = driverName;
		this.cabType = cabType;
		this.ratePerKm = ratePerKm;
		this.city = city;
		this.isAvailable = isAvailable;
	}
	
	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Cab [id=" + id + ", driverName=" + driverName + ", cabType=" + cabType + ", ratePerKm=" + ratePerKm
				+ ", city=" + city + ", isAvailable=" + isAvailable + "]";
	}
    
}