package com.calorie.tracker.controller;

import com.calorie.tracker.security.CustomUserDetails;
import com.calorie.tracker.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/daily")
    public ResponseEntity<Map<String, Object>> getDailyAnalytics(@AuthenticationPrincipal CustomUserDetails userDetails) {
        Map<String, Object> analytics = analyticsService.getDailyAnalytics(userDetails.getId(), LocalDateTime.now());
        return ResponseEntity.ok(analytics);
    }

    @GetMapping("/weekly")
    public ResponseEntity<Map<String, Object>> getWeeklyAnalytics(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(analyticsService.getWeeklyAnalytics(userDetails.getId()));
    }

    @GetMapping("/monthly")
    public ResponseEntity<Map<String, Object>> getMonthlyAnalytics(@AuthenticationPrincipal CustomUserDetails userDetails) {
        // Placeholder for monthly logic
        return ResponseEntity.ok(Map.of("message", "Monthly analytics coming soon"));
    }

    @GetMapping("/calorie-trend")
    public ResponseEntity<Map<String, Object>> getCalorieTrend(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @org.springframework.web.bind.annotation.RequestParam(defaultValue = "7") int days) {
        return ResponseEntity.ok(analyticsService.getCalorieTrend(userDetails.getId(), days));
    }

    @GetMapping("/weight-trend")
    public ResponseEntity<Map<String, Object>> getWeightTrend(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(analyticsService.getWeightTrend(userDetails.getId()));
    }
}
