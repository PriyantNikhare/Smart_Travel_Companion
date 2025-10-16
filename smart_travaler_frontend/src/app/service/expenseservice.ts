import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Expense } from '../expense-manager/expense-manager';

// Define a type for the data sent when creating an expense (without the 'id')
export type CreateExpensePayload = Omit<Expense, 'id' | 'amountPerPerson'>;

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  // The URL of your Spring Boot backend API
  private apiUrl = 'http://localhost:8080/api/expenses';

  constructor(private http: HttpClient) { }

  /**
   * Fetches all expenses from the backend.
   * Corresponds to: GET /api/expenses
   */
  getExpenses(): Observable<Expense[]> {
    return this.http.get<Expense[]>(this.apiUrl);
  }

  /**
   * Sends a new expense to the backend to be saved.
   * Corresponds to: POST /api/expenses
   */
  addExpense(expense: CreateExpensePayload): Observable<Expense> {
    return this.http.post<Expense>(this.apiUrl, expense);
  }

  /**
   * Sends a request to delete an expense by its ID.
   * Corresponds to: DELETE /api/expenses/{id}
   */
  deleteExpense(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}