package com.st.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.model.FlightBooking;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {

}
