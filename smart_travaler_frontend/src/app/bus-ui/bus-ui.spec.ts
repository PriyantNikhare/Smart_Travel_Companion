import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusUi } from './bus-ui';

describe('BusUi', () => {
  let component: BusUi;
  let fixture: ComponentFixture<BusUi>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BusUi]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BusUi);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
