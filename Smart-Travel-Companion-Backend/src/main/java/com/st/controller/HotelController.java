package com.st.controller;

import com.st.dto.HotelBookingRequest;
import com.st.dto.HotelSearchRequest;
import com.st.model.Hotel;
import com.st.model.HotelBooking;
import com.st.service.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/search")
    public ResponseEntity<List<Hotel>> searchHotels(@RequestBody HotelSearchRequest searchRequest) {
        List<Hotel> hotels = hotelService.searchHotels(searchRequest);
        return ResponseEntity.ok(hotels);
    }

    @PostMapping("/book")
    public ResponseEntity<HotelBooking> bookHotel(@RequestBody HotelBookingRequest bookingRequest) {
        try {
            HotelBooking booking = hotelService.bookHotel(bookingRequest);
            return ResponseEntity.ok(booking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    
}
