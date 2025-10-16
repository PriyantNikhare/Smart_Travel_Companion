package com.st.service;

import java.util.List;

import com.st.dto.BusBookingRequest;
import com.st.dto.BusSearchRequest;
import com.st.model.Bus;
import com.st.model.BusBooking;

public interface BusService {

	List<Bus> searchBuses(BusSearchRequest searchRequest);
    BusBooking bookBus(BusBookingRequest bookingRequest);
    
}
