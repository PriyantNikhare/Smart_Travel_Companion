import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Bus } from '../../busbookings/bus.models';
import { PassengerDetails } from '../../flight-ui/booking-modal/booking-modal';

@Component({
  selector: 'app-bus-booking-modal',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './bus-booking-modal.html',
  styleUrls: ['./bus-booking-modal.css']
})
export class BusBookingModal {
  @Input() bus: Bus | null = null;
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