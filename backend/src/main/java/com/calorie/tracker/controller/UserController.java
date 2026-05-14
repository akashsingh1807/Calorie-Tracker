package com.calorie.tracker.controller;

import com.calorie.tracker.dto.WeightLogRequest;
import com.calorie.tracker.dto.WeightLogResponse;
import com.calorie.tracker.model.User;
import com.calorie.tracker.repository.UserRepository;
import com.calorie.tracker.security.CustomUserDetails;
import com.calorie.tracker.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeightService weightService;

    @GetMapping("/me")
    public ResponseEntity<?> getProfile(@AuthenticationPrincipal CustomUserDetails userDetails) {
        User user = userRepository.findById(userDetails.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        return ResponseEntity.ok(java.util.Map.of(
                "id", user.getId(),
                "name", user.getName(),
                "email", user.getEmail(),
                "height", user.getHeight() != null ? user.getHeight() : 0,
                "weight", user.getCurrentWeight() != null ? user.getCurrentWeight() : 0,
                "goal", user.getGoal() != null ? user.getGoal().name() : "MAINTENANCE",
                "dailyCalorieGoal", user.getDailyCalorieGoal() != null ? user.getDailyCalorieGoal() : 2000
        ));
    }

    @PutMapping("/me")
    public ResponseEntity<?> updateProfile(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody java.util.Map<String, Object> updates) {
        // Implement full profile update logic later
        return ResponseEntity.ok(java.util.Map.of("success", true, "message", "Profile updated successfully"));
    }

    @PostMapping("/weight")
    public ResponseEntity<WeightLogResponse> logWeight(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                       @RequestBody WeightLogRequest request) {
        WeightLogResponse response = weightService.logWeight(userDetails.getId(), request);
        return ResponseEntity.ok(response);
    }
}
