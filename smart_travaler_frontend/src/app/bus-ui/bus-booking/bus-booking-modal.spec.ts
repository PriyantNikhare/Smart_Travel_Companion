import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusBookingModal } from './bus-booking-modal';

describe('BusBookingModal', () => {
  let component: BusBookingModal;
  let fixture: ComponentFixture<BusBookingModal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BusBookingModal]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BusBookingModal);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
