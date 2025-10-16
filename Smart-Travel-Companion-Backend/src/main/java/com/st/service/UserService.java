package com.st.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.st.repository.UserRepository;
import com.st.security.JwtService;
import com.st.model.User;
import com.st.dto.SignupRequest;
import com.st.dto.LoginRequest;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @Autowired
  private JwtService jwtService;

  public User register(SignupRequest req) {
    Optional<User> exists = userRepository.findByEmail(req.getEmail());
    if (exists.isPresent()) {
      throw new RuntimeException("Email already in use");
    }

    User user = new User();
    user.setName(req.getName());
    user.setEmail(req.getEmail());
    user.setPassword(passwordEncoder.encode(req.getPassword()));
    user.setPhoneNumber(req.getPhoneNumber());
    user.setRole("USER");

    return userRepository.save(user);
  }

  public User authenticate(LoginRequest req) {
    User user = userRepository.findByEmail(req.getEmail())
        .orElseThrow(() -> new RuntimeException("Invalid credentials"));

    if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
      throw new RuntimeException("Invalid credentials");
    }

    // Generate JWT token
    String token = jwtService.generateToken(user.getEmail());
    
    // Set token manually or return it from a response
    user.setPassword(null); // hide password if returning entity
    user.setRole(token); // just temporary, better to return in AuthResponse

    return user;
  }
}
