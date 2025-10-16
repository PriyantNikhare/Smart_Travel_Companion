package com.st.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.model.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

	List<Train> findByFromStationAndToStationAndDepartureTimeBetweenAndAvailableSeatsGreaterThanEqual(
			String fromStation, 
			String toStation, 
			LocalDateTime startOfDay, 
			LocalDateTime endOfDay, 
			int passengers
	);

}
