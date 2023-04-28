package com.lekwacious.monitor_app.service;

import com.lekwacious.monitor_app.exception.ResourceNotFoundException;
import com.lekwacious.monitor_app.model.Activity;
import com.lekwacious.monitor_app.payload.requestPayload.ActivityRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface ActivityService {
    Activity logActivity(ActivityRequest activityRequest);
    List<Activity> findByUserId(Long aLong) throws ResourceNotFoundException;
    List<Activity> findByDate(LocalDate date) throws ResourceNotFoundException;

    Activity updateActivity(Long activityId) throws ResourceNotFoundException;
}
