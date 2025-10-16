package com.st.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.dto.BusBookingRequest;
import com.st.dto.BusSearchRequest;
import com.st.model.Bus;
import com.st.model.BusBooking;
import com.st.repository.BusBookingRepository;
import com.st.repository.BusRepository;
import com.st.service.BusService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
    private BusRepository busRepository;
    @Autowired
    private BusBookingRepository busBookingRepository;

    @Autowired
    public BusServiceImpl(BusRepository busRepository, BusBookingRepository busBookingRepository) {
        this.busRepository = busRepository;
        this.busBookingRepository = busBookingRepository;
    }

    @Override
    public List<Bus> searchBuses(BusSearchRequest searchRequest) {
        LocalDate date = searchRequest.getTravelDate();
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);

        return busRepository.findByFromCityAndToCityAndDepartureTimeBetweenAndAvailableSeatsGreaterThanEqual(
                searchRequest.getFromCity(),
                searchRequest.getToCity(),
                startOfDay,
                endOfDay,
                searchRequest.getSeats()
        );
    }

    @Override
    @Transactional
    public BusBooking bookBus(BusBookingRequest bookingRequest) {
        Bus bus = busRepository.findById(bookingRequest.getBusId()).get();

        if (bus.getAvailableSeats() < bookingRequest.getNumberOfSeats()) {
            throw new RuntimeException("Not enough available seats on bus " + bus.getBusNumber());
        }

        bus.setAvailableSeats(bus.getAvailableSeats() - bookingRequest.getNumberOfSeats());
        busRepository.save(bus);

        BusBooking booking = new BusBooking();
        booking.setBusId(bus.getId());
        booking.setPassengerName(bookingRequest.getPassengerName());
        booking.setPassengerEmail(bookingRequest.getPassengerEmail());
        booking.setNumberOfSeats(bookingRequest.getNumberOfSeats());
        booking.setTotalPrice(bus.getPrice().multiply(new BigDecimal(bookingRequest.getNumberOfSeats())));
        booking.setBookingTime(LocalDateTime.now());

        return busBookingRepository.save(booking);
    }
}

