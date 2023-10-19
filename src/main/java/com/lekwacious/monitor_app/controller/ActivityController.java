package com.lekwacious.monitor_app.controller;

import com.lekwacious.monitor_app.model.Activity;
import com.lekwacious.monitor_app.payload.requestPayload.ActivityRequest;
import com.lekwacious.monitor_app.payload.responsePayLoad.ActivityBaseResponse;
//import com.lekwacious.monitor_app.repository.HealthStatusProvider;
import com.lekwacious.monitor_app.repository.HealthStatusProvider;
import com.lekwacious.monitor_app.repository.MyComponentHealthStatusProvider;
import com.lekwacious.monitor_app.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Slf4j
@RestController
@RequestMapping("api/v1/timeManager")
public class ActivityController {
    @Autowired
    MyComponentHealthStatusProvider loggingRepository;
    @Autowired
   private  HealthStatusProvider healthStatusProvider;

    @Autowired
    private ActivityService activityService;

    @PostMapping("/log")
    public ResponseEntity<?> addLog(@RequestBody ActivityRequest requestPayLoad){
        Activity activity = activityService.logActivity(requestPayLoad);
        return new ResponseEntity<>(new ActivityBaseResponse(true,"successful",
                HttpStatus.CREATED.value(), LocalDate.now(), activity),HttpStatus.CREATED);

    }


}
