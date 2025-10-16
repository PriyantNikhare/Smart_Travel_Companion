import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cab, CabBooking, CabBookingRequest, CabSearchRequest } from './cab.models';

@Injectable({
  providedIn: 'root'
})

export class CabService {
  private readonly backendUrl = 'http://localhost:8090/api/cabs';

  constructor(private http: HttpClient) { }

  searchCabs(request: CabSearchRequest): Observable<Cab[]> {
    return this.http.post<Cab[]>(`${this.backendUrl}/search`, request);
  }

  bookCab(request: CabBookingRequest): Observable<CabBooking> {
    return this.http.post<CabBooking>(`${this.backendUrl}/book`, request);
  }
}