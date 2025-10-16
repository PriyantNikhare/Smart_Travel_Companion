import { Component } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Hotel, HotelBookingRequest, HotelSearchRequest } from '../hotelbookings/hotel.models';
import { HotelBookingModal } from './hotel-booking-modal/hotel-booking-modal';
import { HotelService } from '../hotelbookings/hotel';
import { PassengerDetails } from '../flight-ui/booking-modal/booking-modal';

@Component({
  selector: 'app-hotel-ui',
  standalone: true,
  imports: [CommonModule, FormsModule, HotelBookingModal],
  templateUrl: './hotel-ui.html',
  styleUrls: ['./hotel-ui.css'],
  providers: [CurrencyPipe]
})
export class HotelUi {
  searchRequest: HotelSearchRequest = {
    city: '',
    checkInDate: '',
    checkOutDate: '',
    numberOfGuests: 1,
    numberOfRooms: 1
  };
  searchResults: Hotel[] = [];
  isLoading = false;
  bookingSuccessMessage = '';
  errorMessage = '';

  isBookingModalVisible = false;
  selectedHotelForBooking: Hotel | null = null;

  constructor(
    private hotelService: HotelService,
    private currencyPipe: CurrencyPipe
  ) {}

  onSearchHotels(): void {
    this.isLoading = true;
    this.searchResults = [];
    this.errorMessage = '';
    this.hotelService.searchHotels(this.searchRequest).subscribe({
      next: (hotels) => { this.searchResults = hotels; this.isLoading = false; },
      error: (err) => { this.errorMessage = 'Failed to fetch hotels.'; this.isLoading = false; }
    });
  }

  openBookingModal(hotel: Hotel): void {
    this.selectedHotelForBooking = hotel;
    this.isBookingModalVisible = true;
  }

  closeBookingModal(): void {
    this.isBookingModalVisible = false;
    this.selectedHotelForBooking = null;
  }

  handleBookingConfirmed(passengerDetails: PassengerDetails): void {
    if (!this.selectedHotelForBooking) return;

    const bookingRequest: HotelBookingRequest = {
      hotelId: this.selectedHotelForBooking.id,
      guestName: passengerDetails.name,
      guestEmail: passengerDetails.email,
      ...this.searchRequest
    };

    this.hotelService.bookHotel(bookingRequest).subscribe({
      next: (booking) => {
        const formattedPrice = this.currencyPipe.transform(booking.totalPrice, 'INR');
        this.bookingSuccessMessage = `Booking successful! Total price: ${formattedPrice}`;
        this.closeBookingModal();
      },
      error: (err) => {
        this.errorMessage = 'Booking failed.';
        this.closeBookingModal();
      }
    });
  }
}