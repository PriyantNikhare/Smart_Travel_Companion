package com.st.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.model.BusBooking;

@Repository
public interface BusBookingRepository extends JpaRepository<BusBooking, Long> {

}
