package com.calorie.tracker.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WeightLogRequest {
    private Double weight;
    private LocalDate date;
}
