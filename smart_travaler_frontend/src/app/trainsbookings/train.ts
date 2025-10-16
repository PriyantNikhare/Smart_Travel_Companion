import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Train, TrainBooking, TrainBookingRequest, TrainSearchRequest } from './train.models';

@Injectable({
  providedIn: 'root'
})

export class TrainService {
  private readonly backendUrl = 'http://localhost:8090/api/trains';

  constructor(private http: HttpClient) { }

  searchTrains(request: TrainSearchRequest): Observable<Train[]> {
    return this.http.post<Train[]>(`${this.backendUrl}/search`, request);
  }

  bookTrain(request: TrainBookingRequest): Observable<TrainBooking> {
    return this.http.post<TrainBooking>(`${this.backendUrl}/book`, request);
  }
}