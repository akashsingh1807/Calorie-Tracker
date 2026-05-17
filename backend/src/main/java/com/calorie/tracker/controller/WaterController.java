package com.calorie.tracker.controller;

import com.calorie.tracker.security.CustomUserDetails;
import com.calorie.tracker.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/water")
public class WaterController {

    @Autowired
    private WaterService waterService;

    @PostMapping("/log")
    public ResponseEntity<Map<String, Object>> logWater(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                       @RequestBody Map<String, Integer> request) {
        Integer amountMl = request.get("amountMl");
        if (amountMl == null) {
            amountMl = request.get("quantityMl"); // Fallback for old clients
        }
        waterService.logWater(userDetails.getId(), amountMl);
        return ResponseEntity.ok(Map.of("success", true));
    }

    @GetMapping("/today")
    public ResponseEntity<Map<String, Object>> getTodayWater(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(waterService.getTodayStats(userDetails.getId()));
    }
}
