import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Hotel, HotelSearchRequest } from '../../hotelbookings/hotel.models';
import { PassengerDetails } from '../../flight-ui/booking-modal/booking-modal';

@Component({
  selector: 'app-hotel-booking-modal',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './hotel-booking-modal.html',
  styleUrls: ['./hotel-booking-modal.css']
})
export class HotelBookingModal {
  @Input() hotel: Hotel | null = null;
  @Input() searchDetails: HotelSearchRequest | null = null;
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