package com.lekwacious.monitor_app.controller;

import com.lekwacious.monitor_app.exception.ResourceNotFoundException;
import com.lekwacious.monitor_app.model.Activity;
import com.lekwacious.monitor_app.payload.requestPayload.ActivityRequest;
import com.lekwacious.monitor_app.payload.requestPayload.DateRequest;
import com.lekwacious.monitor_app.payload.responsePayLoad.ActivityBaseResponse;
import com.lekwacious.monitor_app.payload.responsePayLoad.ActivityListResponse;
import com.lekwacious.monitor_app.payload.responsePayLoad.BaseResponsePayload;
//import com.lekwacious.monitor_app.repository.HealthStatusProvider;
import com.lekwacious.monitor_app.repository.HealthStatusProvider;
import com.lekwacious.monitor_app.repository.MyComponentHealthStatusProvider;
import com.lekwacious.monitor_app.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.web.exchanges.HttpExchange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


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
    @PutMapping("/log/{activityId}")
    public ResponseEntity<?> updateActivity(@PathVariable Long activityId) throws ResourceNotFoundException {
        try {
            Activity user = activityService.updateActivity(activityId);
            return new ResponseEntity<>(new ActivityBaseResponse(true,"successful",
                    HttpStatus.OK.value(), LocalDate.now(),user),HttpStatus.OK);
        }
        catch (ResourceNotFoundException e){
            return new ResponseEntity<>(new BaseResponsePayload(true, e.getMessage(),
                    HttpStatus.BAD_REQUEST.value(), LocalDate.now() ),HttpStatus.BAD_REQUEST);

        }


    }
    @GetMapping("/log/user/{userId}")
    public ResponseEntity<?> getUserActivity(@PathVariable Long userId) throws ResourceNotFoundException {
        try {
            List<Activity> activities = activityService.findByUserId(userId);
            return new ResponseEntity<>(new ActivityListResponse(true,"successful",
                    HttpStatus.OK.value(), LocalDate.now(),activities),HttpStatus.OK);
        }
        catch (ResourceNotFoundException e){
            return new ResponseEntity<>(new BaseResponsePayload(false, e.getMessage(),
                    HttpStatus.BAD_REQUEST.value(), LocalDate.now() ),HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("/log/date")
    public ResponseEntity<?> getActivityByDate(@RequestBody DateRequest date) throws ResourceNotFoundException {
        try {
            List<Activity> activities = activityService.findByDate(date.getDate());
            return new ResponseEntity<>(new ActivityListResponse(true,"successful",
                    HttpStatus.OK.value(), LocalDate.now(),activities),HttpStatus.OK);
        }
        catch (ResourceNotFoundException e){
            return new ResponseEntity<>(new BaseResponsePayload(false, e.getMessage(),
                    HttpStatus.BAD_REQUEST.value(), LocalDate.now() ),HttpStatus.BAD_REQUEST);

        }
    }


}
