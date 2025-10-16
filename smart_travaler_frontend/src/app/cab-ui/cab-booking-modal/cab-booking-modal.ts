import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Cab } from '../../cabbookings/cab.models';

// Interface for the data this modal will emit
export interface CabTripDetails {
  riderName: string;
  riderEmail: string;
  pickupLocation: string;
  dropLocation: string;
  estimatedDistanceKm: number;
}

@Component({
  selector: 'app-cab-booking-modal',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cab-booking-modal.html',
  styleUrls: ['./cab-booking-modal.css']
})

export class CabBookingModal {
  @Input() cab: Cab | null = null;
  @Output() bookingConfirmed = new EventEmitter<CabTripDetails>();
  @Output() closeModal = new EventEmitter<void>();

  tripDetails: CabTripDetails = {
    riderName: '',
    riderEmail: '',
    pickupLocation: '',
    dropLocation: '',
    estimatedDistanceKm: 10 // Default value
  };

  onConfirmBooking(): void {
    this.bookingConfirmed.emit(this.tripDetails);
  }

  onCancel(): void {
    this.closeModal.emit();
  }
}