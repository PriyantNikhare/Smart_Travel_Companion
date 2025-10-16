package com.st.repository;

import com.st.model.CabBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabBookingRepository extends JpaRepository<CabBooking, Long> {
}
