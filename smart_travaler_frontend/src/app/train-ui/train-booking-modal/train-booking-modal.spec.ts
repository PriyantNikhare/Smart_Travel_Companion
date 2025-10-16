import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainBookingModal } from './train-booking-modal';

describe('TrainBookingModal', () => {
  let component: TrainBookingModal;
  let fixture: ComponentFixture<TrainBookingModal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TrainBookingModal]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TrainBookingModal);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
