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
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService{
    @Autowired
    MyComponentHealthStatusProvider loggingRepository;
    @Autowired
    private HealthStatusProvider healthStatusProvider;
    @Autowired
    private ActivityRepository activityRepository;
@Autowired
    private TwilioProperties twilioProperties;

    public void sendWhatsAppMessage(String chat){
        Twilio.init(twilioProperties.getAccount_SID(), twilioProperties.getAuth_SID());
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+2347033621105"),
                        new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                        chat)
                .create();

        System.out.println(message.getSid());
    }


    @Override
    public Activity logActivity(ActivityRequest activityRequest) {
        Activity activity = new Activity();
        activity.setDate(LocalDate.now());
        activity.setIdNumber(activityRequest.getIdNumber());
        activity.setTimeStarted(LocalTime.now());
        activity.setTitle(activityRequest.getTitle());

        activity.setDescription(activityRequest.getDescription());
        //activity.setTimeEnded(activityRequest.getTimeEnded());


        sendWhatsAppMessage(loggingRepository.getHealthStatus().toString());
        sendWhatsAppMessage(healthStatusProvider.getMetricsEndpoint().toString());
        sendWhatsAppMessage(healthStatusProvider.getHealthStatus().toString());
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> findByUserId(Long userId) throws ResourceNotFoundException {
        List<Activity> activity = activityRepository.findByUserId(userId);
        if (activity.isEmpty()){
            throw new ResourceNotFoundException("User have not logged any activity");
        }
        return activity;
    }

    @Override
    public List<Activity> findByDate(LocalDate date) throws ResourceNotFoundException {
        List<Activity> activity = activityRepository.findByDate(date);
        if (activity.isEmpty()){
            throw new ResourceNotFoundException("User have not logged any activity");
        }
        return activity;
    }

    @Override
    public Activity updateActivity(Long activityId) throws ResourceNotFoundException {
        Optional<Activity> activity = activityRepository.findById(activityId);
        if (activity.isPresent()){
            activity.get().setTimeEnded(LocalTime.now());
            return activityRepository.save(activity.get());
        }
        else {
            throw new ResourceNotFoundException("Activity does not exist");
        }

    }
}
