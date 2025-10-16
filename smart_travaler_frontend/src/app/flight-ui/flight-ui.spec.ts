import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightUi } from './flight-ui';

describe('FlightUi', () => {
  let component: FlightUi;
  let fixture: ComponentFixture<FlightUi>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FlightUi]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FlightUi);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
