package com.st.service;

import com.st.dto.CabBookingRequest;
import com.st.dto.CabSearchRequest;
import com.st.model.Cab;
import com.st.model.CabBooking;

import java.util.List;

public interface CabService {
    List<Cab> searchCabs(CabSearchRequest searchRequest);
    CabBooking bookCab(CabBookingRequest bookingRequest);
}
