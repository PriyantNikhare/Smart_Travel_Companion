package com.st.serviceimplementation;

import com.st.dto.CabBookingRequest;
import com.st.dto.CabSearchRequest;
import com.st.model.Cab;
import com.st.model.CabBooking;
import com.st.repository.CabBookingRepository;
import com.st.repository.CabRepository;
import com.st.service.CabService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CabServiceImpl implements CabService {

	@Autowired
    private CabRepository cabRepository;
	@Autowired
	private CabBookingRepository cabBookingRepository;

    @Autowired
    public CabServiceImpl(CabRepository cabRepository, CabBookingRepository cabBookingRepository) {
        this.cabRepository = cabRepository;
        this.cabBookingRepository = cabBookingRepository;
    }

    @Override
    public List<Cab> searchCabs(CabSearchRequest searchRequest) {
        return cabRepository.findByCityIgnoreCaseAndIsAvailableTrue(searchRequest.getCity());
    }

    @Override
    @Transactional
    public CabBooking bookCab(CabBookingRequest bookingRequest) {
        Cab cab = cabRepository.findById(bookingRequest.getCabId())
                .orElseThrow(() -> new RuntimeException("Cab not found with ID: " + bookingRequest.getCabId()));

        if (!cab.isAvailable()) {
            throw new RuntimeException("Cab is not available for booking.");
        }

        // Calculate total fare
        BigDecimal totalFare = cab.getRatePerKm().multiply(bookingRequest.getEstimatedDistanceKm());

        // Create the booking record
        CabBooking booking = new CabBooking();
        booking.setCabId(cab.getId());
        booking.setRiderName(bookingRequest.getRiderName());
        booking.setRiderEmail(bookingRequest.getRiderEmail());
        booking.setPickupLocation(bookingRequest.getPickupLocation());
        booking.setDropLocation(bookingRequest.getDropLocation());
        booking.setEstimatedDistanceKm(bookingRequest.getEstimatedDistanceKm());
        booking.setTotalFare(totalFare);
        booking.setBookingTime(LocalDateTime.now());
        
        // Update the cab's availability
        cab.setAvailable(false);
        cabRepository.save(cab);

        return cabBookingRepository.save(booking);
    }
}
