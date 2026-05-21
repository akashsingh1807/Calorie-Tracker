package com.calorie.tracker.service;

import com.calorie.tracker.dto.WeightLogRequest;
import com.calorie.tracker.dto.WeightLogResponse;
import com.calorie.tracker.model.User;
import com.calorie.tracker.model.WeightLog;
import com.calorie.tracker.repository.UserRepository;
import com.calorie.tracker.repository.WeightLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

@Service
public class WeightService {

    @Autowired
    private WeightLogRepository weightLogRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public WeightLogResponse logWeight(Long userId, WeightLogRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        LocalDate logDate = request.getDate() != null ? request.getDate() : LocalDate.now();

        WeightLog log = WeightLog.builder()
                .user(user)
                .weight(request.getWeight())
                .date(logDate)
                .build();

        // Also update current weight in user profile
        user.setCurrentWeight(request.getWeight());
        userRepository.save(user);

        WeightLog savedLog = weightLogRepository.save(log);

        return WeightLogResponse.builder()
                .id(savedLog.getId())
                .weight(savedLog.getWeight())
                .date(savedLog.getDate())
                .build();
    }

    public List<WeightLogResponse> getWeightLogs(Long userId) {
        return weightLogRepository.findByUserIdOrderByDateAsc(userId).stream()
                .map(log -> WeightLogResponse.builder()
                        .id(log.getId())
                        .weight(log.getWeight())
                        .date(log.getDate())
                        .build())
                .collect(Collectors.toList());
    }
}
