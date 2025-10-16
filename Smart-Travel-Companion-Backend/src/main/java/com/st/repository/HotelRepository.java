package com.st.repository;

import com.st.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // Simple derived query to find all hotels in a given city
    List<Hotel> findByCityIgnoreCase(String city);
}
