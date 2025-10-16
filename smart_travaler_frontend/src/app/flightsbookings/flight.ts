import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Flight, FlightBooking, FlightBookingRequest, FlightSearchRequest } from './flight.models';

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  private readonly backendUrl = 'http://localhost:8090/api/flights';

  constructor(private http: HttpClient) { }

  /**
   * Searches for flights by sending a POST request to the backend.
   * @param request The search criteria.
   * @returns An Observable array of Flight objects.
   */

  searchFlights(request: FlightSearchRequest): Observable<Flight[]> {
    return this.http.post<Flight[]>(`${this.backendUrl}/search`, request);
  }

  /**
   * Books a flight by sending a POST request.
   * @param request The booking details.
   * @returns An Observable of the created FlightBooking object.
   */
  
  bookFlight(request: FlightBookingRequest): Observable<FlightBooking> {
    return this.http.post<FlightBooking>(`${this.backendUrl}/book`, request);
  }
}