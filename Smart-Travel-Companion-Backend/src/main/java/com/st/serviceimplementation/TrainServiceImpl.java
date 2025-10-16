package com.st.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.dto.TrainBookingRequest;
import com.st.dto.TrainSearchRequest;
import com.st.model.Train;
import com.st.model.TrainBooking;
import com.st.repository.TrainBookingRepository;
import com.st.repository.TrainRepository;
import com.st.service.TrainService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
    private TrainRepository trainRepository;
	@Autowired
    private TrainBookingRepository trainBookingRepository;

    @Autowired
    public TrainServiceImpl(TrainRepository trainRepository, TrainBookingRepository trainBookingRepository) {
        this.trainRepository = trainRepository;
        this.trainBookingRepository = trainBookingRepository;
    }

    @Override
    public List<Train> searchTrains(TrainSearchRequest searchRequest) {
        LocalDate date = searchRequest.getJourneyDate();
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);

        return trainRepository.findByFromStationAndToStationAndDepartureTimeBetweenAndAvailableSeatsGreaterThanEqual(
                searchRequest.getFromStation(),
                searchRequest.getToStation(),
                startOfDay,
                endOfDay,
                searchRequest.getPassengers()
        );
    }

    @Override
    @Transactional
    public TrainBooking bookTrain(TrainBookingRequest bookingRequest) {
        Train train = trainRepository.findById(bookingRequest.getTrainId()).get();

        if (train.getAvailableSeats() < bookingRequest.getNumberOfPassengers()) {
            throw new RuntimeException("Not enough available seats on train " + train.getTrainNumber());
        }

        train.setAvailableSeats(train.getAvailableSeats() - bookingRequest.getNumberOfPassengers());
        trainRepository.save(train);

        TrainBooking booking = new TrainBooking();
        booking.setTrainId(train.getId());
        booking.setPassengerName(bookingRequest.getPassengerName());
        booking.setPassengerEmail(bookingRequest.getPassengerEmail());
        booking.setNumberOfPassengers(bookingRequest.getNumberOfPassengers());
        booking.setTotalPrice(train.getPrice().multiply(new BigDecimal(bookingRequest.getNumberOfPassengers())));
        booking.setBookingTime(LocalDateTime.now());

        return trainBookingRepository.save(booking);
    }
}
