import { Component } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Bus, BusBookingRequest, BusSearchRequest } from '../busbookings/bus.models';
import { BusBookingModal } from './bus-booking/bus-booking-modal';
import { BusService } from '../busbookings/bus';
import { PassengerDetails } from '../flight-ui/booking-modal/booking-modal';

@Component({
  selector: 'app-bus-ui',
  standalone: true,
  imports: [CommonModule, FormsModule, BusBookingModal],
  templateUrl: './bus-ui.html',
  styleUrls: ['./bus-ui.css'],
  providers: [CurrencyPipe]
})
export class BusUi {
  searchRequest: BusSearchRequest = {
    fromCity: '',
    toCity: '',
    travelDate: '',
    seats: 1
  };
  searchResults: Bus[] = [];
  isLoading = false;
  bookingSuccessMessage = '';
  errorMessage = '';

  isBookingModalVisible = false;
  selectedBusForBooking: Bus | null = null;

  constructor(
    private busService: BusService,
    private currencyPipe: CurrencyPipe
  ) {}

  onSearchBuses(): void {
    this.isLoading = true;
    this.searchResults = [];
    this.errorMessage = '';
    this.busService.searchBuses(this.searchRequest).subscribe({
      next: (buses) => { this.searchResults = buses; this.isLoading = false; },
      error: (err) => { this.errorMessage = 'Failed to fetch buses.'; this.isLoading = false; }
    });
  }

  openBookingModal(bus: Bus): void {
    this.selectedBusForBooking = bus;
    this.isBookingModalVisible = true;
  }

  closeBookingModal(): void {
    this.isBookingModalVisible = false;
    this.selectedBusForBooking = null;
  }

  handleBookingConfirmed(passengerDetails: PassengerDetails): void {
    if (!this.selectedBusForBooking) return;

    const bookingRequest: BusBookingRequest = {
      busId: this.selectedBusForBooking.id,
      passengerName: passengerDetails.name,
      passengerEmail: passengerDetails.email,
      numberOfSeats: this.searchRequest.seats
    };

    this.busService.bookBus(bookingRequest).subscribe({
      next: (booking) => {
        this.bookingSuccessMessage = `Booking successful!`;
        this.closeBookingModal();
        this.onSearchBuses();
      },
      error: (err) => {
        this.errorMessage = 'Booking failed.';
        this.closeBookingModal();
      }
    });
  }
}