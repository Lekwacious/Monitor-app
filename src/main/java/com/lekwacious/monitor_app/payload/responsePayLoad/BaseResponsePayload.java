package com.lekwacious.monitor_app.payload.responsePayLoad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponsePayload {
    private boolean isSuccessful;
    private String message;
    private int responseCode;
    private LocalDate timeStamp = LocalDate.now();
}

