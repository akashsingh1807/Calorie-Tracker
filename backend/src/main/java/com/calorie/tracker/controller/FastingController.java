package com.calorie.tracker.controller;

import com.calorie.tracker.security.CustomUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/fasting")
public class FastingController {

    @PostMapping("/start")
    public ResponseEntity<Map<String, Object>> startFast(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(Map.of("success", true, "startTime", LocalDateTime.now(), "message", "Fast started"));
    }

    @PostMapping("/end")
    public ResponseEntity<Map<String, Object>> endFast(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(Map.of("success", true, "endTime", LocalDateTime.now(), "durationHours", 16.5, "message", "Fast ended"));
    }

    @GetMapping("/history")
    public ResponseEntity<Map<String, Object>> getFastingHistory(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(Map.of("fasts", List.of()));
    }
}
