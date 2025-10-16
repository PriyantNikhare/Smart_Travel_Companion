package com.st.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.st.model.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    // JPQL query to find flights based on origin, destination, and departure date

	@Query("SELECT f FROM Flight f WHERE f.origin = :origin AND f.destination = :destination AND f.departureTime BETWEEN :startOfDay AND :endOfDay AND f.availableSeats >= :seats")
	List<Flight> searchFlights(
	        @Param("origin") String origin,
	        @Param("destination") String destination,
	        @Param("startOfDay") LocalDateTime startOfDay,
	        @Param("endOfDay") LocalDateTime endOfDay,
	        @Param("seats") int seats
	);
}
