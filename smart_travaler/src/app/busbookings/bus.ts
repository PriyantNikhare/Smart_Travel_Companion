import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bus, BusBooking, BusBookingRequest, BusSearchRequest } from './bus.models';

@Injectable({
  providedIn: 'root'
})

export class BusService {
  private readonly backendUrl = 'http://localhost:8090/api/buses';

  constructor(private http: HttpClient) { }

  searchBuses(request: BusSearchRequest): Observable<Bus[]> {
    return this.http.post<Bus[]>(`${this.backendUrl}/search`, request);
  }

  bookBus(request: BusBookingRequest): Observable<BusBooking> {
    return this.http.post<BusBooking>(`${this.backendUrl}/book`, request);
  }
}