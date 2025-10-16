import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CabUi } from './cab-ui';

describe('CabUi', () => {
  let component: CabUi;
  let fixture: ComponentFixture<CabUi>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CabUi]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CabUi);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
