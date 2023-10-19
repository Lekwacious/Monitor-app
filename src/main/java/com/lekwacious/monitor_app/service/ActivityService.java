package com.lekwacious.monitor_app.service;

import com.lekwacious.monitor_app.model.Activity;
import com.lekwacious.monitor_app.payload.requestPayload.ActivityRequest;
import org.springframework.stereotype.Component;


@Component
public interface ActivityService {
    Activity logActivity(ActivityRequest activityRequest);

}
