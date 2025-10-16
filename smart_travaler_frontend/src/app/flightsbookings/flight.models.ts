// This interface matches the Flight entity from Spring Boot
export interface Flight {
  id: number;
  flightNumber: string;
  airline: string;
  origin: string;
  destination: string;
  departureTime: string; // ISO date string
  arrivalTime: string;   // ISO date string
  price: number;
  availableSeats: number;
}

// This matches the SearchRequest DTO
export interface FlightSearchRequest {
  origin: string;
  destination: string;
  departureDate: string; // YYYY-MM-DD format
  seats: number;
}

// This matches the BookingRequest DTO
export interface FlightBookingRequest {
  flightId: number;
  passengerName: string;
  passengerEmail: string;
  numberOfTravelers: number;
}

// This matches the Booking entity returned after a successful booking
export interface FlightBooking {
  id: number;
  flightId: number;
  passengerName: string;
  passengerEmail: string;
  numberOfTravelers: number;
  totalPrice: number;
  bookingTime: string;
}