package com.calorie.tracker.controller;

import com.calorie.tracker.security.CustomUserDetails;
import com.calorie.tracker.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/media")
public class MediaController {

    @Autowired
    private S3Service s3Service;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadMedia(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                           @RequestParam("file") MultipartFile file) {
        String imageUrl = s3Service.uploadFile(file);
        return ResponseEntity.ok(Map.of("imageUrl", imageUrl));
    }
}
