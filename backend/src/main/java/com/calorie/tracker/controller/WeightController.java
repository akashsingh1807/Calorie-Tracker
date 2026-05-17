package com.calorie.tracker.controller;

import com.calorie.tracker.dto.WeightLogRequest;
import com.calorie.tracker.dto.WeightLogResponse;
import com.calorie.tracker.security.CustomUserDetails;
import com.calorie.tracker.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/weight")
public class WeightController {

    @Autowired
    private WeightService weightService;

    @PostMapping("/log")
    public ResponseEntity<WeightLogResponse> logWeight(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestBody WeightLogRequest request) {
        return ResponseEntity.ok(weightService.logWeight(userDetails.getId(), request));
    }

    @GetMapping("/history")
    public ResponseEntity<List<WeightLogResponse>> getWeightHistory(
            @AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(weightService.getWeightLogs(userDetails.getId()));
    }
}
