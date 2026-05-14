package com.calorie.tracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        return ResponseEntity.ok(Map.of("users", List.of()));
    }

    @PutMapping("/users/{id}/block")
    public ResponseEntity<Map<String, Object>> blockUser(@PathVariable Long id) {
        return ResponseEntity.ok(Map.of("success", true, "message", "User blocked"));
    }

    @GetMapping("/metrics/ai-usage")
    public ResponseEntity<Map<String, Object>> getAiUsageMetrics() {
        return ResponseEntity.ok(Map.of("totalRequests", 1500, "successRate", 98.5));
    }
}
