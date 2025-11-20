package com.subhra.eduskill.service;

import com.subhra.eduskill.dto.AuthResponse;
import com.subhra.eduskill.dto.LoginRequest;
import com.subhra.eduskill.dto.RegisterRequest;
import com.subhra.eduskill.entity.Role;
import com.subhra.eduskill.entity.User;
import com.subhra.eduskill.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerStudent(RegisterRequest request) {

        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.STUDENT);

        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

//        System.out.println("DB password = " + user.getPassword());
//        System.out.println("Raw password = " + passwordEncoder.encode(request.getPassword()));
//        System.out.println("Matches? " + passwordEncoder.matches(request.getPassword(), user.getPassword()));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = "dummy-token-" + user.getId();
        return new AuthResponse(token, user.getRole().name());
    }
}

