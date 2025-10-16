package com.st.service;

import com.st.dto.TripRequest;
import com.st.model.Trip;
import com.st.model.User;
import com.st.repository.TripRepository;
import com.st.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final UserRepository userRepository;

    public TripService(TripRepository tripRepository, UserRepository userRepository) {
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
    }

    public Trip createTrip(TripRequest req) {
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Trip trip = new Trip(
                req.getDestination(),
                req.getStartDate(),
                req.getEndDate(),
                req.getBudget(),
                req.getPreferences(),
                user
        );

        return tripRepository.save(trip);
    }

    public List<Trip> getUserTrips(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return tripRepository.findByUser(user);
    }

    public void deleteTrip(Long tripId) {
        tripRepository.deleteById(tripId);
    }
}
