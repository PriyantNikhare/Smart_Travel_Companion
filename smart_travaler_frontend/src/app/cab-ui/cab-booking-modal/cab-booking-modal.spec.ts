import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CabBookingModal } from './cab-booking-modal';

describe('CabBookingModal', () => {
  let component: CabBookingModal;
  let fixture: ComponentFixture<CabBookingModal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CabBookingModal]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CabBookingModal);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
