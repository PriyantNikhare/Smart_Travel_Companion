import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginRegisterService {
  private loginUrl = "http://localhost:8080/api/auth/login";
  private registerUrl = "http://localhost:8080/api/auth/signup";

  constructor(private http: HttpClient) {}

  public login(loginForm: any) {
    return this.http.post(this.loginUrl, loginForm);
  }

  public register(registerForm: any) {
    return this.http.post(this.registerUrl, registerForm);
  }
}
