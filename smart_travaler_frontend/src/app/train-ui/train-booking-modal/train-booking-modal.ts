import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Train } from '../../trainsbookings/train.models'; // <-- Use Train models
import { PassengerDetails } from '../../flight-ui/booking-modal/booking-modal';

@Component({
  selector: 'app-train-booking-modal',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './train-booking-modal.html',
  styleUrls: ['./train-booking-modal.css']
})
export class TrainBookingModal {
  @Input() train: Train | null = null; // <-- Changed to accept a Train
  @Output() bookingConfirmed = new EventEmitter<PassengerDetails>();
  @Output() closeModal = new EventEmitter<void>();

  passengerDetails: PassengerDetails = { name: '', email: '' };

  onConfirmBooking(): void {
    this.bookingConfirmed.emit(this.passengerDetails);
  }

  onCancel(): void {
    this.closeModal.emit();
  }
}