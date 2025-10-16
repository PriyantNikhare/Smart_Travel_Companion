package com.st.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.st.dto.BusBookingRequest;
import com.st.dto.BusSearchRequest;
import com.st.model.Bus;
import com.st.model.BusBooking;
import com.st.service.BusService;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
@CrossOrigin
public class BusController {

	@Autowired
    private BusService busService;

    @Autowired
    public BusController(BusService busService) {
        this.busService = busService;
    }
    
    @PostMapping("/search")
    public ResponseEntity<List<Bus>> searchBuses(@RequestBody BusSearchRequest searchRequest) {
        List<Bus> buses = busService.searchBuses(searchRequest);
        return ResponseEntity.ok(buses);
    }

    @PostMapping("/book")
    public ResponseEntity<BusBooking> bookBus(@RequestBody BusBookingRequest bookingRequest) {
        try {
            BusBooking booking = busService.bookBus(bookingRequest);
            return ResponseEntity.ok(booking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
