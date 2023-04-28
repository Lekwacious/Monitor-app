package com.lekwacious.monitor_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long activityId;
    private String idNumber;
    private Long userId;
    private String title;
    private String description;
    private LocalDate date;
    private LocalTime timeStarted;
    private LocalTime timeEnded;


}
