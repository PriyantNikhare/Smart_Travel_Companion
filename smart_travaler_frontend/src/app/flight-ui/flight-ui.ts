import { Component } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common'; // Import CurrencyPipe
import { FormsModule } from '@angular/forms';
import { Flight, FlightBookingRequest, FlightSearchRequest } from '../flightsbookings/flight.models';

// 1. Import your new modal component and its data structure
import { BookingModal, PassengerDetails } from './booking-modal/booking-modal';
import { FlightService } from '../flightsbookings/flight';

@Component({
  selector: 'app-flight-ui',
  standalone: true,
  // 2. Add BookingModalComponent to the imports array
  imports: [CommonModule, FormsModule, BookingModal],
  templateUrl: './flight-ui.html',
  styleUrls: ['./flight-ui.css'],
  // 3. Add CurrencyPipe to the component's providers
  providers: [CurrencyPipe]
})
export class FlightUi {

  searchRequest: FlightSearchRequest = {
    origin: '',
    destination: '',
    departureDate: '',
    seats: 1
  };
  searchResults: Flight[] = [];
  isLoading = false;
  bookingSuccessMessage = '';
  errorMessage = '';

  // 4. ADD properties to manage the modal
  isBookingModalVisible = false;
  selectedFlightForBooking: Flight | null = null;
  
  // 5. INJECT CurrencyPipe in the constructor
  constructor(
    private flightService: FlightService,
    private currencyPipe: CurrencyPipe
  ) {}

  onSearchFlights(): void {
    this.isLoading = true;
    this.searchResults = [];
    this.errorMessage = '';
    this.bookingSuccessMessage = '';

    console.log('Sending search request:', this.searchRequest); 

    this.flightService.searchFlights(this.searchRequest).subscribe({
      next: (flights) => {
        this.searchResults = flights;
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Error searching flights:', err);
        this.errorMessage = 'Failed to fetch flights. Please try again later.';
        this.isLoading = false;
      }
    });
  }
  
  // 6. ADD the missing methods to open, close, and handle the modal logic

  /**
   * Called when "Book Now" is clicked. It sets the selected flight
   * and makes the modal visible.
   */
  openBookingModal(flight: Flight): void {
    this.selectedFlightForBooking = flight;
    this.isBookingModalVisible = true;
  }

  /**
   * Closes the modal.
   */
  closeBookingModal(): void {
    this.isBookingModalVisible = false;
    this.selectedFlightForBooking = null;
  }

  /**
   * Called by the modal's event emitter when the user confirms the booking.
   * This now contains the logic to call the backend service.
   */
  handleBookingConfirmed(passengerDetails: PassengerDetails): void {
    if (!this.selectedFlightForBooking) return;

    const bookingRequest: FlightBookingRequest = {
      flightId: this.selectedFlightForBooking.id,
      passengerName: passengerDetails.name,
      passengerEmail: passengerDetails.email,
      numberOfTravelers: this.searchRequest.seats
    };

    this.flightService.bookFlight(bookingRequest).subscribe({
      next: (booking) => {
        const formattedPrice = this.currencyPipe.transform(booking.totalPrice, 'INR');
        this.bookingSuccessMessage = `Booking successful! ID: ${booking.id}. Total: ${formattedPrice}`;
        this.closeBookingModal();
      },

      error: (err) => {
        console.error('Error booking flight:', err);
        this.errorMessage = 'Booking failed. Please try again.';
        this.closeBookingModal();
      }
    });
  }
}