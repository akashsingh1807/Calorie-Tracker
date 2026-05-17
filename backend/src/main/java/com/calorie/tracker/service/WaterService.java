package com.calorie.tracker.service;

import com.calorie.tracker.model.User;
import com.calorie.tracker.model.WaterLog;
import com.calorie.tracker.repository.UserRepository;
import com.calorie.tracker.repository.WaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class WaterService {

    @Autowired
    private WaterRepository waterRepository;

    @Autowired
    private UserRepository userRepository;

    public WaterLog logWater(Long userId, Integer amountMl) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        WaterLog log = WaterLog.builder()
                .user(user)
                .quantityMl(amountMl)
                .build();
        
        return waterRepository.save(log);
    }

    public Map<String, Object> getTodayStats(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        LocalDateTime start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);

        Integer total = waterRepository.sumQuantityMlByUserAndTimestampBetween(user, start, end);
        
        Map<String, Object> stats = new HashMap<>();
        stats.put("amountMl", total != null ? total : 0);
        // Also used by dashboard:
        stats.put("totalMl", total != null ? total : 0); 
        
        return stats;
    }
}
