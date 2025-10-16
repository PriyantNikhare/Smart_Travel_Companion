import { Component } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Cab, CabBookingRequest, CabSearchRequest } from '../cabbookings/cab.models';
import { CabBookingModal, CabTripDetails } from './cab-booking-modal/cab-booking-modal';
import { CabService } from '../cabbookings/cab';

@Component({
  selector: 'app-cab-ui',
  standalone: true,
  imports: [CommonModule, FormsModule, CabBookingModal],
  templateUrl: './cab-ui.html',
  styleUrls: ['./cab-ui.css'],
  providers: [CurrencyPipe]
})

export class CabUi {
  searchRequest: CabSearchRequest = { city: '' };
  searchResults: Cab[] = [];
  isLoading = false;
  bookingSuccessMessage = '';
  errorMessage = '';

  isBookingModalVisible = false;
  selectedCabForBooking: Cab | null = null;

  constructor(
    private cabService: CabService,
    private currencyPipe: CurrencyPipe
  ) {}

  onSearchCabs(): void {
    this.isLoading = true;
    this.searchResults = [];
    this.errorMessage = '';
    this.cabService.searchCabs(this.searchRequest).subscribe({
      next: (cabs) => { this.searchResults = cabs; this.isLoading = false; },
      error: (err) => { this.errorMessage = 'Failed to fetch cabs.'; this.isLoading = false; }
    });
  }

  openBookingModal(cab: Cab): void {
    this.selectedCabForBooking = cab;
    this.isBookingModalVisible = true;
  }

  closeBookingModal(): void {
    this.isBookingModalVisible = false;
    this.selectedCabForBooking = null;
  }

  handleBookingConfirmed(tripDetails: CabTripDetails): void {
    if (!this.selectedCabForBooking) return;

    const bookingRequest: CabBookingRequest = {
      cabId: this.selectedCabForBooking.id,
      ...tripDetails
    };

    this.cabService.bookCab(bookingRequest).subscribe({
      next: (booking) => {
        const formattedPrice = this.currencyPipe.transform(booking.totalFare, 'INR');
        this.bookingSuccessMessage = `Booking successful! Your total fare is ${formattedPrice}.`;
        this.closeBookingModal();
        this.onSearchCabs(); // Refresh list to show updated availability
      },
      error: (err) => {
        this.errorMessage = 'Booking failed.';
        this.closeBookingModal();
      }
    });
  }
}