package com.lekwacious.monitor_app.repository;

import com.lekwacious.monitor_app.model.Activity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface ActivityRepository  {
    List<Activity> findByUserId(Long aLong);
    List<Activity> findByDate(LocalDate date);
}
