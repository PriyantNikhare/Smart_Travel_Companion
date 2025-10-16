package com.st.serviceimplementation;

import com.st.dto.HotelBookingRequest;
import com.st.dto.HotelSearchRequest;
import com.st.model.Hotel;
import com.st.model.HotelBooking;
import com.st.repository.HotelBookingRepository;
import com.st.repository.HotelRepository;
import com.st.service.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelBookingRepository hotelBookingRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository, HotelBookingRepository hotelBookingRepository) {
        this.hotelRepository = hotelRepository;
        this.hotelBookingRepository = hotelBookingRepository;
    }

    @Override
    public List<Hotel> searchHotels(HotelSearchRequest searchRequest) {
        // For now, we search only by city. More complex logic can be added later.
        return hotelRepository.findByCityIgnoreCase(searchRequest.getCity());
    }

    @Override
    @Transactional
    public HotelBooking bookHotel(HotelBookingRequest bookingRequest) {
        Hotel hotel = hotelRepository.findById(bookingRequest.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found with ID: " + bookingRequest.getHotelId()));

        // Calculate the number of nights
        long numberOfNights = ChronoUnit.DAYS.between(bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate());
        if (numberOfNights <= 0) {
            throw new RuntimeException("Check-out date must be after check-in date.");
        }

        // Calculate total price: (Price Per Night * Number of Rooms * Number of Nights)
        BigDecimal totalPrice = hotel.getPricePerNight()
                                    .multiply(BigDecimal.valueOf(bookingRequest.getNumberOfRooms()))
                                    .multiply(BigDecimal.valueOf(numberOfNights));

        HotelBooking booking = new HotelBooking();
        booking.setHotelId(hotel.getId());
        booking.setGuestName(bookingRequest.getGuestName());
        booking.setGuestEmail(bookingRequest.getGuestEmail());
        booking.setCheckInDate(bookingRequest.getCheckInDate());
        booking.setCheckOutDate(bookingRequest.getCheckOutDate());
        booking.setNumberOfGuests(bookingRequest.getNumberOfGuests());
        booking.setNumberOfRooms(bookingRequest.getNumberOfRooms());
        booking.setTotalPrice(totalPrice);
        booking.setBookingTime(LocalDateTime.now());

        return hotelBookingRepository.save(booking);
    }
}
