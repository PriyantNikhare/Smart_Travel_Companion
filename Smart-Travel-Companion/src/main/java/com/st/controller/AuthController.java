package com.st.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.st.service.UserService;
import com.st.dto.SignupRequest;
import com.st.model.User;
import com.st.security.JwtService;
import com.st.dto.LoginRequest;
import com.st.dto.AuthResponse;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  private UserService userService;
  
  @Autowired
  private JwtService jwtService;

  @PostMapping("/signup")
  public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest req) {
    try {
      var saved = userService.register(req);
      return ResponseEntity.ok(new AuthResponse(saved.getId(), saved.getName(), saved.getEmail(), null));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req) {
    try {
      User user = userService.authenticate(req);
      String token = jwtService.generateToken(user.getEmail());
      return ResponseEntity.ok(new AuthResponse(user.getId(), user.getName(), user.getEmail(), token));
    } catch (Exception e) {
      return ResponseEntity.status(401).body(e.getMessage());
    }
  }

}
