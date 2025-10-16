package com.st.service;

import java.util.List;

import com.st.dto.FlightBookingRequest;
import com.st.dto.FlightSearchRequest;
import com.st.model.FlightBooking;
import com.st.model.Flight;

public interface FlightService {

	List<Flight> searchFlights(FlightSearchRequest searchRequest);

    FlightBooking bookFlight(FlightBookingRequest bookingRequest);
    
}
