package com.sparta.mydatemanagement.repository;

import com.sparta.mydatemanagement.controller.Controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Service
@NoArgsConstructor

public class Schedule  {
    private Long id;
    private String task;
    private String password;
    private String manager;
    private LocalDateTime first_Date;
    private LocalDateTime last_Date;

//    public void update(sRequestDto requestDto) {
//        this.manager = requestDto.getManager();
//        this.task = requestDto.getTask();
//    }
    public Schedule (Long id, String task, String manager, LocalDateTime first_Date, LocalDateTime last_Date){
        this.id=id;
        this.task=task;
        this.manager=manager;
        this.first_Date = first_Date;
        this.last_Date=last_Date;
    }
    public void update(String task, String manager){
        this.task =task;
        this.manager = manager;
        this.last_Date=LocalDateTime.now();
    }

    public void setId(Long id) {
    }
}
