import { ChangeDetectionStrategy, Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common';

type BookingType = 'Flight' | 'Train' | 'Bus' | 'Car' | 'Hotel';

@Component({
  selector: 'app-homepage',
  imports: [CommonModule],
  templateUrl: './homepage.html',
  styleUrls: ['./homepage.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class Homepage {

  readonly bookingTypes: BookingType[] = ['Flight', 'Train', 'Bus', 'Car', 'Hotel'];
  activeTab = signal<BookingType>('Flight');

  // Add this signal for your modal state
  modalState = signal({
    isOpen: false,
    title: '',
    message: '',
  });

  constructor() {}

  setActiveTab(tab: BookingType): void {
    this.activeTab.set(tab);
  }

  getIcon(type: BookingType): string {
    switch (type) {
      case 'Flight': return '✈️';
      case 'Train': return '🚆';
      case 'Bus': return '🚌';
      case 'Car': return '🚗';
      case 'Hotel': return '🏨';
      default: return '📍';
    }
  }

  showProfileModal(): void {
    this.modalState.set({
      isOpen: true,
      title: 'User Profile & Settings',
      message: 'This section would contain your personal information, saved trips, and account settings. This is currently a mock up.',
    });
  }

  showExpenseModal(): void {
    this.modalState.set({
      isOpen: true,
      title: 'Expense Management Tool',
      message: 'This tool would allow you to log and track expenses for your trips, including budget planning and spending reports. This is currently a mock up.',
    });
  }
  
  closeModal(): void {
    this.modalState.set({ isOpen: false, title: '', message: '' });
  }
}