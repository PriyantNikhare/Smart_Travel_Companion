import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Hotel, HotelBooking, HotelBookingRequest, HotelSearchRequest } from './hotel.models';

@Injectable({
  providedIn: 'root'
})

export class HotelService {
  private readonly backendUrl = 'http://localhost:8090/api/hotels';

  constructor(private http: HttpClient) { }

  searchHotels(request: HotelSearchRequest): Observable<Hotel[]> {
    return this.http.post<Hotel[]>(`${this.backendUrl}/search`, request);
  }

  bookHotel(request: HotelBookingRequest): Observable<HotelBooking> {
    return this.http.post<HotelBooking>(`${this.backendUrl}/book`, request);
  }
}