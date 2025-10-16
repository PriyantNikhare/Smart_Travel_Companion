package com.st.service;

import com.st.dto.HotelBookingRequest;
import com.st.dto.HotelSearchRequest;
import com.st.model.Hotel;
import com.st.model.HotelBooking;

import java.util.List;

public interface HotelService {
	
    List<Hotel> searchHotels(HotelSearchRequest searchRequest);
    HotelBooking bookHotel(HotelBookingRequest bookingRequest);

}
