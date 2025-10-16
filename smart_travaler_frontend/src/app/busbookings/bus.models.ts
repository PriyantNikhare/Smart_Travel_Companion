export interface Bus {
  id: number;
  busNumber: string;
  operatorName: string;
  fromCity: string;
  toCity: string;
  departureTime: string;
  arrivalTime: string;
  busType: string;
  price: number;
  availableSeats: number;
}

export interface BusSearchRequest {
  fromCity: string;
  toCity: string;
  travelDate: string;
  seats: number;
}

export interface BusBookingRequest {
  busId: number;
  passengerName: string;
  passengerEmail: string;
  numberOfSeats: number;
}

export interface BusBooking {
  id: number;
  busId: number;
  passengerName: string;
  // ... other properties returned by your backend
}