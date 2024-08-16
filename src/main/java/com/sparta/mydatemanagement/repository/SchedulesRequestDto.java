package com.sparta.mydatemanagement.repository;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
public class SchedulesRequestDto {

    private Long id;
    private String task;
    private String manager;
    private String password;
    private LocalDateTime first_Date;
    private LocalDateTime last_Date;
}
