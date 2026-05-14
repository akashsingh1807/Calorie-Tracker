package com.calorie.tracker.repository;

import com.calorie.tracker.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    
    @Query("SELECT m FROM Meal m WHERE m.user.id = :userId AND m.timestamp >= :startOfDay AND m.timestamp < :endOfDay")
    List<Meal> findMealsByUserAndDate(@Param("userId") Long userId, 
                                      @Param("startOfDay") LocalDateTime startOfDay, 
                                      @Param("endOfDay") LocalDateTime endOfDay);
}
