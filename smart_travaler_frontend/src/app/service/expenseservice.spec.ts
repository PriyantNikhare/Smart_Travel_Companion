import { TestBed } from '@angular/core/testing';

import { Expenseservice } from './expenseservice';

describe('Expenseservice', () => {
  let service: Expenseservice;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Expenseservice);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
