package com.st.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.st.dto.FlightBookingRequest;
import com.st.dto.FlightSearchRequest;
import com.st.model.FlightBooking;
import com.st.model.Flight;
import com.st.service.FlightService;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(@RequestBody FlightSearchRequest searchRequest) {
        List<Flight> flights = flightService.searchFlights(searchRequest);
        return ResponseEntity.ok(flights);
    }

    @PostMapping("/book")
    public ResponseEntity<FlightBooking> bookFlight(@RequestBody FlightBookingRequest bookingRequest) {
        FlightBooking booking = flightService.bookFlight(bookingRequest);
        return ResponseEntity.ok(booking);
    }
}

