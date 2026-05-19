package com.calorie.tracker.controller;

import com.calorie.tracker.security.CustomUserDetails;
import com.calorie.tracker.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/daily")
    public ResponseEntity<Map<String, Object>> getDailyAnalytics(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestParam(value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        LocalDateTime targetDateTime = (date != null) ? date.atStartOfDay() : LocalDateTime.now();
        Map<String, Object> analytics = analyticsService.getDailyAnalytics(userDetails.getId(), targetDateTime);
        return ResponseEntity.ok(analytics);
    }

    @GetMapping("/weekly")
    public ResponseEntity<List<Map<String, Object>>> getWeeklyAnalytics(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(analyticsService.getWeeklyAnalytics(userDetails.getId()));
    }

    @GetMapping("/monthly")
    public ResponseEntity<List<Map<String, Object>>> getMonthlyAnalytics(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(analyticsService.getMonthlyAnalytics(userDetails.getId()));
    }

    @GetMapping("/calorie-trend")
    public ResponseEntity<Map<String, Object>> getCalorieTrend(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestParam(defaultValue = "7") int days) {
        return ResponseEntity.ok(analyticsService.getCalorieTrend(userDetails.getId(), days));
    }

    @GetMapping("/weight-trend")
    public ResponseEntity<Map<String, Object>> getWeightTrend(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(analyticsService.getWeightTrend(userDetails.getId()));
    }
}

