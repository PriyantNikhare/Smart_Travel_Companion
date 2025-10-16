export interface Hotel {
  id: number;
  hotelName: string;
  city: string;
  address: string;
  rating: number;
  pricePerNight: number;
  amenities: string;
}

export interface HotelSearchRequest {
  city: string;
  checkInDate: string;
  checkOutDate: string;
  numberOfGuests: number;
  numberOfRooms: number;
}

export interface HotelBookingRequest {
  hotelId: number;
  guestName: string;
  guestEmail: string;
  checkInDate: string;
  checkOutDate: string;
  numberOfGuests: number;
  numberOfRooms: number;
}

export interface HotelBooking {
  id: number;
  hotelId: number;
  totalPrice: number;
  // ... other properties
}