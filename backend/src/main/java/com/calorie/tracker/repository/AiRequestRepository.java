package com.calorie.tracker.repository;

import com.calorie.tracker.model.AiRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AiRequestRepository extends JpaRepository<AiRequest, Long> {
    List<AiRequest> findByUserId(Long userId);
}
