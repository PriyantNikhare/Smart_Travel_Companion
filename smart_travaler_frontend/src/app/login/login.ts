import { Component, inject, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { LoginRegisterService } from '../service/loginregister';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
  ],
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class Login implements OnInit {
  loginForm!: FormGroup;
  errorMessage: string | null = null;
  isSubmitting: boolean = false; // This property was added to fix the error

  // Use inject() for modern, constructor-less dependency injection
  private fb = inject(FormBuilder);
  private service = inject(LoginRegisterService);
  private router = inject(Router);

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  // Helper getter for easy access to form controls in the template
  get f() {
    return this.loginForm.controls;
  }

  onSubmit() {
    this.errorMessage = null;
    if (this.loginForm.invalid) {
      this.loginForm.markAllAsTouched();
      return;
    }

    this.isSubmitting = true; // Set to true when submission starts

    this.service.login(this.loginForm.value).subscribe({
      next: (response: any) => {
        console.log('✅ Login successful:', response);
        
        if (response && response.token) {
          localStorage.setItem('auth_token', response.token);
        }

        this.router.navigate(['/homepage']);
        this.isSubmitting = false; // Set back to false on success
      },
      error: (err) => {
        console.error('❌ Login error:', err);
        this.errorMessage = err.error?.message || 'Invalid credentials or server error.';
        this.isSubmitting = false; // Also set back to false on error
      }
    });
  }
}

