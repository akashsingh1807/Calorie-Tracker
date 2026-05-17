package com.calorie.tracker.repository;

import com.calorie.tracker.model.WaterLog;
import com.calorie.tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WaterRepository extends JpaRepository<WaterLog, Long> {
    List<WaterLog> findByUserAndTimestampBetween(User user, LocalDateTime start, LocalDateTime end);

    @Query("SELECT SUM(w.quantityMl) FROM WaterLog w WHERE w.user = :user AND w.timestamp BETWEEN :start AND :end")
    Integer sumQuantityMlByUserAndTimestampBetween(User user, LocalDateTime start, LocalDateTime end);
}
