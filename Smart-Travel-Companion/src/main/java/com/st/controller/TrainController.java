package com.st.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.st.dto.TrainBookingRequest;
import com.st.dto.TrainSearchRequest;
import com.st.model.Train;
import com.st.model.TrainBooking;
import com.st.service.TrainService;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
@CrossOrigin
public class TrainController {

	@Autowired
    private TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @PostMapping("/search")
    public ResponseEntity<List<Train>> searchTrains(@RequestBody TrainSearchRequest searchRequest) {
        List<Train> trains = trainService.searchTrains(searchRequest);
        return ResponseEntity.ok(trains);
    }

    @PostMapping("/book")
    public ResponseEntity<TrainBooking> bookTrain(@RequestBody TrainBookingRequest bookingRequest) {
        try {
            TrainBooking booking = trainService.bookTrain(bookingRequest);
            return ResponseEntity.ok(booking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
