import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainUi } from './train-ui';

describe('TrainUi', () => {
  let component: TrainUi;
  let fixture: ComponentFixture<TrainUi>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TrainUi]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TrainUi);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
