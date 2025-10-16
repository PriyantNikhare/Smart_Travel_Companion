import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelUi } from './hotel-ui';

describe('HotelUi', () => {
  let component: HotelUi;
  let fixture: ComponentFixture<HotelUi>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HotelUi]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelUi);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
