package com.calorie.tracker.service;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
public class S3Service {

    @Value("${minio.url}")
    private String minioUrl;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    @Value("${minio.bucketName}")
    private String bucketName;

    private MinioClient minioClient;

    @PostConstruct
    public void init() {
        try {
            minioClient = MinioClient.builder()
                    .endpoint(minioUrl)
                    .credentials(accessKey, secretKey)
                    .build();

            boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!isExist) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
        } catch (Throwable t) {
            System.err.println("Warning: MinIO is unreachable or failed to initialize. S3 uploads will fail until MinIO is configured. Error: " + t.getMessage());
        }
    }

    public String uploadFile(MultipartFile file) {
        try {
            if (minioClient == null) {
                throw new RuntimeException("MinIO client is not initialized");
            }
            String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
            InputStream is = file.getInputStream();

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .stream(is, file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build()
            );

            return minioClient.getPresignedObjectUrl(
                    io.minio.GetPresignedObjectUrlArgs.builder()
                            .method(io.minio.http.Method.GET)
                            .bucket(bucketName)
                            .object(fileName)
                            .expiry(3600)
                            .build()
            );

        } catch (Exception e) {
            System.err.println("S3 upload failed, falling back to Base64: " + e.getMessage());
            try {
                byte[] bytes = file.getBytes();
                String base64 = java.util.Base64.getEncoder().encodeToString(bytes);
                return "data:" + file.getContentType() + ";base64," + base64;
            } catch (Exception ex) {
                throw new RuntimeException("Error falling back to Base64 upload", ex);
            }
        }
    }
}
