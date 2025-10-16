package com.st.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.model.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

	List<Bus> findByFromCityAndToCityAndDepartureTimeBetweenAndAvailableSeatsGreaterThanEqual(
			String fromCity,
			String toCity, 
			LocalDateTime startOfDay, 
			LocalDateTime endOfDay, 
			int seats
	);

}
