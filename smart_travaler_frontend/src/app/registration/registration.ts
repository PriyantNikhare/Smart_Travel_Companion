import { Component, inject } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common'; // Import CommonModule
import { FormsModule } from '@angular/forms'; // Import FormsModule
import { LoginRegisterService } from '../service/loginregister'; // Adjust path if needed

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    RouterLink,
    CommonModule, // Add CommonModule for @if
    FormsModule   // Add FormsModule for ngModel and form features
  ],
  templateUrl: './registration.html',
  styleUrls: ['./registration.css']
})
export class Register {
  // Use inject() for modern, constructor-less dependency injection
  private loginregisterService = inject(LoginRegisterService);
  private router = inject(Router);

  // Optional: Add a property to show error messages in the UI
  errorMessage: string | null = null;

  onSubmit(name: string, email: string, password: string, phoneNumber: string) {
    this.errorMessage = null; // Clear previous errors
    const data = { name, email, password, phoneNumber };

    this.loginregisterService.register(data).subscribe({
      next: (response) => {
        console.log('✅ Registration successful:', response);
        
        // --- THIS IS THE KEY CHANGE ---
        // On success, navigate directly to the homepage route.
        this.router.navigate(['/homepage']); 
      },
      error: (err) => {
        console.error('❌ Registration error:', err);
        // Display a user-friendly error message in the template
        this.errorMessage = err.error?.message || 'An unknown registration error occurred.';
      }
    });
  }
}

