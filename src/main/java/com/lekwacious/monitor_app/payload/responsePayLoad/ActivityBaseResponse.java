package com.lekwacious.monitor_app.payload.responsePayLoad;

import com.lekwacious.monitor_app.model.Activity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ActivityBaseResponse extends BaseResponsePayload{
    private Activity response;
    public ActivityBaseResponse (Boolean isSuccessful, String message, Integer responseCode, LocalDate timeStamp,
                                 Activity response){
        super(isSuccessful, message, responseCode, timeStamp);
        this.response = response;

    }
}

