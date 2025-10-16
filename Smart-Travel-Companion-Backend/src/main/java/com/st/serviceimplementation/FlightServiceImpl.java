package com.st.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.dto.FlightBookingRequest;
import com.st.dto.FlightSearchRequest;
import com.st.model.FlightBooking;
import com.st.model.Flight;
import com.st.repository.FlightBookingRepository;
import com.st.repository.FlightRepository;
import com.st.service.FlightService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service 
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightBookingRepository bookingRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, FlightBookingRepository bookingRepository) {
        this.flightRepository = flightRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Flight> searchFlights(FlightSearchRequest searchRequest) {
        LocalDate date = searchRequest.getDepartureDate();
        LocalDateTime startOfDay = date.atStartOfDay(); // e.g., 2025-11-12T00:00:00
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);   // e.g., 2025-11-12T23:59:59.999...

        return flightRepository.searchFlights(
            searchRequest.getOrigin(),
            searchRequest.getDestination(),
            startOfDay,  // Pass start time
            endOfDay,    // Pass end time
            searchRequest.getSeats()
        );
    }

    @Override
    @Transactional // Ensures the whole method runs in a single database transaction
    public FlightBooking bookFlight(FlightBookingRequest bookingRequest) {
        // 1. Find the flight
        Flight flight = flightRepository.findById(bookingRequest.getFlightId())
                .orElseThrow(() -> new RuntimeException("Flight not found with ID: " + bookingRequest.getFlightId()));

        // 2. Check for available seats
        if (flight.getAvailableSeats() < bookingRequest.getNumberOfTravelers()) {
            throw new RuntimeException("Not enough available seats on flight " + flight.getFlightNumber());
        }

        // 3. Update the available seats on the flight
        flight.setAvailableSeats(flight.getAvailableSeats() - bookingRequest.getNumberOfTravelers());
        flightRepository.save(flight);

        // 4. Create and save the new booking
        FlightBooking booking = new FlightBooking();
        booking.setFlightId(flight.getId());
        booking.setPassengerName(bookingRequest.getPassengerName());
        booking.setPassengerEmail(bookingRequest.getPassengerEmail());
        booking.setNumberOfTravelers(bookingRequest.getNumberOfTravelers());
        
        // Calculate total price
        BigDecimal totalPrice = flight.getPrice().multiply(new BigDecimal(bookingRequest.getNumberOfTravelers()));
        booking.setTotalPrice(totalPrice);
        booking.setBookingTime(LocalDateTime.now());

        return bookingRepository.save(booking);
    }
}
