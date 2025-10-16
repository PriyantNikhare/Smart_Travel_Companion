import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Flight } from '../../flightsbookings/flight.models';

export interface PassengerDetails {
  name: string;
  email: string;
}

@Component({
  selector: 'app-booking-modal',
  standalone: true,
  imports: [ CommonModule, FormsModule ],
  templateUrl: './booking-modal.html',
  styleUrls: ['./booking-modal.css']
})
export class BookingModal {
  // Receive the selected flight from the parent component
  @Input() flight: Flight | null = null;

  // Send the confirmed booking details back to the parent
  @Output() bookingConfirmed = new EventEmitter<PassengerDetails>();
  // Send a signal to close the modal
  @Output() closeModal = new EventEmitter<void>();

  passengerDetails: PassengerDetails = { name: '', email: '' };

  onConfirmBooking(): void {
    this.bookingConfirmed.emit(this.passengerDetails);
  }

  onCancel(): void {
    this.closeModal.emit();
  }
}
