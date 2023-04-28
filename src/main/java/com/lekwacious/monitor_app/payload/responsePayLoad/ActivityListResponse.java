package com.lekwacious.monitor_app.payload.responsePayLoad;

import com.lekwacious.monitor_app.model.Activity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityListResponse extends BaseResponsePayload {
    private List<Activity> response;
    public ActivityListResponse (Boolean isSuccessful, String message, Integer responseCode, LocalDate timeStamp,
                                 List<Activity> response){
        super(isSuccessful, message, responseCode, timeStamp);
        this.response = response;

    }
}


