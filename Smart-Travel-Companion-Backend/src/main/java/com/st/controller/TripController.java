package com.st.controller;

import com.st.dto.TripRequest;
import com.st.model.Trip;
import com.st.service.TripService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/create")
    public ResponseEntity<Trip> createTrip(@RequestBody TripRequest request) {
        Trip trip = tripService.createTrip(request);
        return ResponseEntity.ok(trip);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Trip>> getUserTrips(@PathVariable Long userId) {
        List<Trip> trips = tripService.getUserTrips(userId);
        return ResponseEntity.ok(trips);
    }

    @DeleteMapping("/{tripId}")
    public ResponseEntity<String> deleteTrip(@PathVariable Long tripId) {
        tripService.deleteTrip(tripId);
        return ResponseEntity.ok("Trip deleted successfully");
    }
}
