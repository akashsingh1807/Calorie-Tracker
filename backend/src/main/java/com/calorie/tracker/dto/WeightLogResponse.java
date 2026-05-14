package com.calorie.tracker.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class WeightLogResponse {
    private Long id;
    private Double weight;
    private LocalDate date;
}
