package com.lekwacious.monitor_app.service;

import com.lekwacious.monitor_app.config.TwilioProperties;
import com.lekwacious.monitor_app.exception.ResourceNotFoundException;
import com.lekwacious.monitor_app.model.Activity;
import com.lekwacious.monitor_app.payload.requestPayload.ActivityRequest;
import com.lekwacious.monitor_app.repository.ActivityRepository;
import com.lekwacious.monitor_app.repository.HealthStatusProvider;
import com.lekwacious.monitor_app.repository.MyComponentHealthStatusProvider;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Component
public class ActivityServiceImpl implements ActivityService{
    @Autowired
    MyComponentHealthStatusProvider loggingRepository;
    @Autowired
    private  HealthStatusProvider healthStatusProvider;
    @Autowired(required = false)
    private  ActivityRepository activityRepository;
    @Autowired
    private  TwilioProperties twilioProperties;



    public void sendWhatsAppMessage(String chat){
        Twilio.init(twilioProperties.getAccount_SID(), twilioProperties.getAuth_SID());
        System.out.println(twilioProperties.getAccount_SID());

        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+2347033621105"),
                        new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                        chat)
                .create();

    }


    @Override
    public Activity logActivity(ActivityRequest activityRequest) {
        Activity activity = new Activity();
        activity.setDate(LocalDate.now());
        activity.setIdNumber(activityRequest.getIdNumber());
        activity.setTimeStarted(LocalTime.now());
        activity.setTitle(activityRequest.getTitle());

        activity.setDescription(activityRequest.getDescription());

        System.out.println(loggingRepository.getHealthStatus().toString());
        System.out.println(loggingRepository.getMetricsEndpoint().toString());
        System.out.println(healthStatusProvider.getHealthStatus().toString());

        sendWhatsAppMessage(loggingRepository.getHealthStatus().toString());
        sendWhatsAppMessage(healthStatusProvider.getMetricsEndpoint().toString());
        sendWhatsAppMessage(healthStatusProvider.getHealthStatus().toString());
        return activity;
    }

}
