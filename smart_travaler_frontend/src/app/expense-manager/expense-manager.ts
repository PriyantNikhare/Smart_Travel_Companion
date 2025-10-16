import { Component, signal, computed, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CreateExpensePayload, ExpenseService } from '../service/expenseservice';


export interface Expense {
  id: number;
  category: string;
  description: string;
  date: string; // Keep as YYYY-MM-DD string
  amount: number;
  splitWith?: number;
  amountPerPerson?: number;
}

@Component({
  selector: 'app-expense-manager',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './expense-manager.html',
  styleUrls: ['./expense-manager.css']
})
export class ExpenseManager implements OnInit {

  // Inject the service
  private expenseService = inject(ExpenseService);

  expenses = signal<Expense[]>([]);
  totalAmount = computed(() =>
    this.expenses().reduce((sum, expense) => sum + expense.amount, 0)
  );

  // Form model properties
  newExpenseCategory: string = 'Flight';
  newExpenseDescription: string = '';
  newExpenseDate: string = new Date().toISOString().split('T')[0];
  newExpenseAmount: number | null = null;
  selectedGroup = signal('single');
  numberOfMembers: number = 2;
  memberCountOptions: number[] = Array.from({ length: 19 }, (_, i) => i + 2);
  
  totalPerPerson = computed(() => {
    const total = this.totalAmount();
    const members = this.numberOfMembers;
    if (this.selectedGroup() === 'multiple' && members > 0) {
      return total / members;
    }
    return 0;
  });

  // Fetch initial data when the component loads
  ngOnInit(): void {
    this.loadExpenses();
  }

  loadExpenses(): void {
    this.expenseService.getExpenses().subscribe({
      next: (data) => this.expenses.set(data),
      error: (err) => console.error('Failed to load expenses', err)
    });
  }

  addExpense(): void {
    if (!this.newExpenseDescription || !this.newExpenseAmount || this.newExpenseAmount <= 0) {
      console.error('Please fill in a valid description and amount.');
      return;
    }

    const payload: CreateExpensePayload = {
      category: this.newExpenseCategory,
      description: this.newExpenseDescription.trim(),
      date: this.newExpenseDate, // Ensure this is YYYY-MM-DD
      amount: this.newExpenseAmount,
    };
    
    // Add splitWith only if it's a group expense
    if (this.selectedGroup() === 'multiple' && this.numberOfMembers > 1) {
      payload.splitWith = this.numberOfMembers;
    }

    this.expenseService.addExpense(payload).subscribe({
      next: (newExpenseFromServer) => {
        this.expenses.update(current => [...current, newExpenseFromServer]);
        this.resetForm();
      },
      error: (err) => console.error('Failed to add expense', err)
    });
  }

  removeExpense(expenseId: number): void {
    this.expenseService.deleteExpense(expenseId).subscribe({
      next: () => {
        this.expenses.update(current =>
          current.filter(expense => expense.id !== expenseId)
        );
      },
      error: (err) => console.error('Failed to remove expense', err)
    });
  }
  
  private resetForm(): void {
    this.newExpenseDescription = '';
    this.newExpenseAmount = null;
    this.newExpenseDate = new Date().toISOString().split('T')[0];
    this.newExpenseCategory = 'Flight';
  }
}