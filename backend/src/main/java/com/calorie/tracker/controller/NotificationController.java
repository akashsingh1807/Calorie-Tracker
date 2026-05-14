package com.calorie.tracker.controller;

import com.calorie.tracker.security.CustomUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    @PostMapping("/token")
    public ResponseEntity<Map<String, Object>> registerDeviceToken(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                                   @RequestBody Map<String, String> request) {
        return ResponseEntity.ok(Map.of("success", true, "message", "Device token registered"));
    }

    @PutMapping("/preferences")
    public ResponseEntity<Map<String, Object>> updatePreferences(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                                 @RequestBody Map<String, Object> request) {
        return ResponseEntity.ok(Map.of("success", true, "message", "Preferences updated"));
    }
}
