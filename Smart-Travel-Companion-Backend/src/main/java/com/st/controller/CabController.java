package com.st.controller;

import com.st.dto.CabBookingRequest;
import com.st.dto.CabSearchRequest;
import com.st.model.Cab;
import com.st.model.CabBooking;
import com.st.service.CabService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cabs")
@CrossOrigin
public class CabController {

	@Autowired
    private CabService cabService;

    @Autowired
    public CabController(CabService cabService) {
        this.cabService = cabService;
    }

    @PostMapping("/search")
    public ResponseEntity<List<Cab>> searchCabs(@RequestBody CabSearchRequest searchRequest) {
        List<Cab> cabs = cabService.searchCabs(searchRequest);
        return ResponseEntity.ok(cabs);
    }

    @PostMapping("/book")
    public ResponseEntity<CabBooking> bookCab(@RequestBody CabBookingRequest bookingRequest) {
        try {
            CabBooking booking = cabService.bookCab(bookingRequest);
            return ResponseEntity.ok(booking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}