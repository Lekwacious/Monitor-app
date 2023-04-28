package com.lekwacious.monitor_app.repository;

import com.lekwacious.monitor_app.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByUserId(Long aLong);
    List<Activity> findByDate(LocalDate date);
}
