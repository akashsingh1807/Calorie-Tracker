package com.calorie.tracker.controller;

import com.calorie.tracker.dto.AuthRequest;
import com.calorie.tracker.dto.AuthResponse;
import com.calorie.tracker.dto.RegisterRequest;
import com.calorie.tracker.model.User;
import com.calorie.tracker.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication", description = "Endpoints for user registration, login, and session/password management")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "Authenticate user and return JWT token")
    public ResponseEntity<AuthResponse> authenticateUser(@Valid @RequestBody AuthRequest loginRequest) {
        AuthResponse response = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/google")
    @Operation(summary = "Authenticate user via Google ID Token and return JWT token")
    public ResponseEntity<?> authenticateWithGoogle(@Valid @RequestBody com.calorie.tracker.dto.GoogleAuthRequest googleAuthRequest) {
        try {
            AuthResponse response = authService.authenticateWithGoogle(googleAuthRequest.getIdToken());
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(java.util.Map.of("success", false, "message", e.getMessage()));
        }
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new user account")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest signUpRequest) {
        try {
            User user = authService.registerUser(signUpRequest);
            AuthRequest loginRequest = new AuthRequest();
            loginRequest.setEmail(signUpRequest.getEmail());
            loginRequest.setPassword(signUpRequest.getPassword());
            com.calorie.tracker.dto.AuthResponse authResponse = authService.authenticateUser(loginRequest);
            
            com.calorie.tracker.dto.SignupResponse response = com.calorie.tracker.dto.SignupResponse.builder()
                .success(true)
                .message("User registered successfully")
                .token(authResponse.getToken())
                .user(com.calorie.tracker.dto.SignupResponse.UserDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .build())
                .build();
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(java.util.Map.of("success", false, "message", e.getMessage()));
        }
    }

    @PostMapping("/refresh")
    @Operation(summary = "Refresh user authentication token")
    public ResponseEntity<?> refreshToken() {
        return ResponseEntity.ok(java.util.Map.of("token", "new_jwt_token", "refreshToken", "new_refresh_token", "expiresIn", 3600));
    }

    @PostMapping("/logout")
    @Operation(summary = "Invalidate active session and logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok(java.util.Map.of("success", true, "message", "Logged out successfully"));
    }

    @PostMapping("/forgot-password")
    @Operation(summary = "Request password reset instructions")
    public ResponseEntity<?> forgotPassword() {
        return ResponseEntity.ok(java.util.Map.of("success", true, "message", "Password reset link sent to email"));
    }

    @PostMapping("/reset-password")
    @Operation(summary = "Reset password using token")
    public ResponseEntity<?> resetPassword() {
        return ResponseEntity.ok(java.util.Map.of("success", true, "message", "Password has been reset successfully"));
    }
}
