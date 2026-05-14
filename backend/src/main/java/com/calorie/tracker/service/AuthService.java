package com.calorie.tracker.service;

import com.calorie.tracker.dto.AuthRequest;
import com.calorie.tracker.dto.AuthResponse;
import com.calorie.tracker.dto.RegisterRequest;
import com.calorie.tracker.model.User;
import com.calorie.tracker.repository.UserRepository;
import com.calorie.tracker.security.CustomUserDetails;
import com.calorie.tracker.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtils jwtUtils;

    public AuthResponse authenticateUser(AuthRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        return new AuthResponse(jwt, "dummy_refresh_token", 86400);
    }

    public User registerUser(RegisterRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new RuntimeException("Error: Email is already in use!");
        }

        int defaultCalories = 2000;
        if (signUpRequest.getGoal() != null) {
            switch (signUpRequest.getGoal()) {
                case FAT_LOSS:
                    defaultCalories = 1800;
                    break;
                case MUSCLE_GAIN:
                    defaultCalories = 2500;
                    break;
                case MAINTENANCE:
                default:
                    defaultCalories = 2000;
                    break;
            }
        }

        User user = User.builder()
                .name(signUpRequest.getName())
                .email(signUpRequest.getEmail())
                .passwordHash(encoder.encode(signUpRequest.getPassword()))
                .height(signUpRequest.getHeight())
                .currentWeight(signUpRequest.getWeight())
                .goal(signUpRequest.getGoal())
                .dailyCalorieGoal(defaultCalories)
                .build();

        return userRepository.save(user);
    }
}
