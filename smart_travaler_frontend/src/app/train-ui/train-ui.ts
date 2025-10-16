import { Component } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Train, TrainBookingRequest, TrainSearchRequest } from '../trainsbookings/train.models';
import { TrainService } from '../trainsbookings/train';
// We can reuse the same booking modal and passenger details interface
import { BookingModal, PassengerDetails } from '../flight-ui/booking-modal/booking-modal';
import { TrainBookingModal } from './train-booking-modal/train-booking-modal';

@Component({
  selector: 'app-train-ui',
  standalone: true,
  imports: [CommonModule, FormsModule, TrainBookingModal],
  templateUrl: './train-ui.html',
  styleUrls: ['./train-ui.css'],
  providers: [CurrencyPipe]
})

export class TrainUi {
  searchRequest: TrainSearchRequest = {
    fromStation: '',
    toStation: '',
    journeyDate: '',
    passengers: 1
  };
  searchResults: Train[] = [];
  isLoading = false;
  bookingSuccessMessage = '';
  errorMessage = '';

  isBookingModalVisible = false;
  selectedTrainForBooking: Train | null = null;

  constructor(
    private trainService: TrainService,
    private currencyPipe: CurrencyPipe
  ) {}

  onSearchTrains(): void {
    this.isLoading = true;
    this.searchResults = [];
    this.errorMessage = '';
    this.bookingSuccessMessage = '';
    this.trainService.searchTrains(this.searchRequest).subscribe({
      next: (trains) => {
        this.searchResults = trains;
        this.isLoading = false;
      },
      error: (err) => {
        this.errorMessage = 'Failed to fetch trains. Please try again.';
        this.isLoading = false;
      }
    });
  }

  openBookingModal(train: Train): void {
    this.selectedTrainForBooking = train;
    this.isBookingModalVisible = true;
  }

  closeBookingModal(): void {
    this.isBookingModalVisible = false;
    this.selectedTrainForBooking = null;
  }

  handleBookingConfirmed(passengerDetails: PassengerDetails): void {
    if (!this.selectedTrainForBooking) return;

    const bookingRequest: TrainBookingRequest = {
      trainId: this.selectedTrainForBooking.id,
      passengerName: passengerDetails.name,
      passengerEmail: passengerDetails.email,
      numberOfPassengers: this.searchRequest.passengers
    };

    this.trainService.bookTrain(bookingRequest).subscribe({
      next: (booking) => {
        const formattedPrice = this.currencyPipe.transform(booking.totalPrice, 'INR');
        this.bookingSuccessMessage = `Booking successful! ID: ${booking.id}. Total: ${formattedPrice}`;
        this.closeBookingModal();
      },
      error: (err) => {
        this.errorMessage = 'Booking failed. Please try again.';
        this.closeBookingModal();
      }
    });
  }
}