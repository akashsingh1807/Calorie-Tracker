package com.calorie.tracker.dto;

import com.calorie.tracker.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignupResponse {
    private boolean success;
    private String message;
    private String token;
    private UserDto user;

    @Data
    @Builder
    public static class UserDto {
        private Long id;
        private String name;
    }
}
