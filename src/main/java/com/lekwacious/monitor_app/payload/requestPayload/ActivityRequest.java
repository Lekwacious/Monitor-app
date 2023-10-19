package com.lekwacious.monitor_app.payload.requestPayload;

import lombok.Data;

@Data
public class ActivityRequest {
    private Integer userId;
    private String idNumber;
    private String title;
    private String description;
}
