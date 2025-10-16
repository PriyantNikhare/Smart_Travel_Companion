package com.st.service;

import java.util.List;

import com.st.dto.TrainBookingRequest;
import com.st.dto.TrainSearchRequest;
import com.st.model.Train;
import com.st.model.TrainBooking;

public interface TrainService {

	List<Train> searchTrains(TrainSearchRequest searchRequest);

	TrainBooking bookTrain(TrainBookingRequest bookingRequest);
	
}
