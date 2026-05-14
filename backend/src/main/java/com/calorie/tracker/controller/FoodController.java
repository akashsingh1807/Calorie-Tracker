package com.calorie.tracker.controller;

import com.calorie.tracker.security.CustomUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/foods")
public class FoodController {

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchFoods(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                           @RequestParam("q") String query) {
        // Placeholder for real database search
        return ResponseEntity.ok(Map.of(
                "foods", List.of(
                        Map.of(
                                "id", 1,
                                "name", query + " (Mock)",
                                "serving", "1 medium",
                                "calories", 105
                        )
                )
        ));
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<Map<String, Object>> getFoodDetails(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                              @PathVariable Long foodId) {
        return ResponseEntity.ok(Map.of("id", foodId, "name", "Banana"));
    }

    @GetMapping("/recent")
    public ResponseEntity<Map<String, Object>> getRecentFoods(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(Map.of("foods", List.of()));
    }

    @GetMapping("/favorites")
    public ResponseEntity<Map<String, Object>> getFavoriteFoods(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(Map.of("foods", List.of()));
    }

    @PostMapping("/favorites")
    public ResponseEntity<Map<String, Object>> addFavoriteFood(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                               @RequestBody Map<String, Object> request) {
        return ResponseEntity.ok(Map.of("success", true, "message", "Added to favorites"));
    }
}
