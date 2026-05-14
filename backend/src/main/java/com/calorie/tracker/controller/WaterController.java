package com.calorie.tracker.controller;

import com.calorie.tracker.security.CustomUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/water")
public class WaterController {

    @PostMapping
    public ResponseEntity<Map<String, Object>> addWaterIntake(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                              @RequestBody Map<String, Integer> request) {
        Integer quantity = request.get("quantityMl");
        // Placeholder for saving to DB
        return ResponseEntity.ok(Map.of("success", true, "quantityAdded", quantity));
    }

    @GetMapping("/daily")
    public ResponseEntity<Map<String, Object>> getDailyWaterIntake(@AuthenticationPrincipal CustomUserDetails userDetails) {
        // Placeholder for calculating daily total
        return ResponseEntity.ok(Map.of("totalQuantityMl", 1500));
    }
}
