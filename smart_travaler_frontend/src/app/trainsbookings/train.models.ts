export interface Train {
  id: number;
  trainNumber: string;
  trainName: string;
  fromStation: string;
  toStation: string;
  departureTime: string;
  arrivalTime: string;
  seatClass: string;
  price: number;
  availableSeats: number;
}

export interface TrainSearchRequest {
  fromStation: string;
  toStation: string;
  journeyDate: string;
  passengers: number;
}

export interface TrainBookingRequest {
  trainId: number;
  passengerName: string;
  passengerEmail: string;
  numberOfPassengers: number;
}

export interface TrainBooking {
  id: number;
  trainId: number;
  passengerName: string;
  passengerEmail: string;
  numberOfPassengers: number;
  totalPrice: number;
  bookingTime: string;
}