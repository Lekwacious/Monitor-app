package com.lekwacious.monitor_app.payload.requestPayload;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DateRequest {
    private LocalDate date;
}
