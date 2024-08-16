package com.sparta.mydatemanagement.repository;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String task;
    private String manager;
    private LocalDateTime first_Date;
    private LocalDateTime last_Date;

    public ScheduleResponseDto(Schedule schedule){
        this.id = schedule.getId();
        this.task= schedule.getTask();
        this.manager=schedule.getManager();
        this.first_Date=schedule.getFirst_Date();
        this.last_Date = schedule.getLast_Date();
    }

    public Comparable<Object> getDate() {
    }
}
