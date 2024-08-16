package com.sparta.mydatemanagement.service;

import com.sparta.mydatemanagement.repository.Schedule;
import com.sparta.mydatemanagement.repository.ScheduleRepository;
import com.sparta.mydatemanagement.repository.ScheduleResponseDto;
import com.sparta.mydatemanagement.repository.SchedulesRequestDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }
    public ScheduleResponseDto createSchedule(SchedulesRequestDto requestDto) {
        Schedule schedule = new Schedule(
                null,
                requestDto.getTask(),
                requestDto.getManager(),
                requestDto.getFirst_Date(),
                requestDto.getLast_Date()
        );
        Schedule saveSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(saveSchedule);
    }
    public ScheduleResponseDto getSchedule(Long id) {
    }
    public List<ScheduleResponseDto> getSchedules(String manager, String date) {
    }
    public ScheduleResponseDto updateSchedule(Long id, SchedulesRequestDto requestDto) {
    }
    public Long deleteSchedule(Long id) {
    }

}
