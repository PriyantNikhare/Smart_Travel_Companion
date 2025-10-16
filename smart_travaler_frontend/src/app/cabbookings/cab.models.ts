export interface Cab {
  id: number;
  driverName: string;
  cabType: string;
  ratePerKm: number;
  city: string;
  available: boolean;
}

export interface CabSearchRequest {
  city: string;
}

export interface CabBookingRequest {
  cabId: number;
  riderName: string;
  riderEmail: string;
  pickupLocation: string;
  dropLocation: string;
  estimatedDistanceKm: number;
}

export interface CabBooking {
  id: number;
  cabId: number;
  totalFare: number;
  // ... other properties returned by your backend
}