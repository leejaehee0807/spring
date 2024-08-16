package com.sparta.mydatemanagement.controller;

import com.sparta.mydatemanagement.repository.;
import com.sparta.mydatemanagement.repository.Repository;
import com.sparta.mydatemanagement.repository.ResponseDto;
import com.sparta.mydatemanagement.repository.sRequestDto;
import com.sparta.mydatemanagement.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController // Controller + ResponseBody
@RequestMapping("/api") // 중복되는 URL 단축
public class Controller {

    private final Map<Long,Schedule> scheduleList = new HashMap<>();

    @PostMapping("/schedule")
    public String createSchedule(@RequestBody SchedulesRequestDto requestDto){
        // RequestDto -> Entity
        Schedule schedule = new Schedule(requestDto);
        // Scheduel Max ID Check
        Long maxId = scheduleList.size() > 0 ? Collections.max(scheduleList.keySet())+1 :1;
        schedule.setId(maxId);
        // DB 저장
        scheduleList.put(schedule.getId(), schedule);
        // Entity --> ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);

        return scheduleResponseDto;
    }

    @GetMapping("/sget")
    public List<ScheduleResponseDto> getSchedules(){
        List<ScheduleResponseDto> scheduleResponseDtoList = new ArrayList<>(scheduleList.values().stream().map(ScheduleResponseDto::new).toList());
        Collections.sort(scheduleResponseDtoList, (o1, o2) -> o2.getDate().compareTo(o1.getDate()));
        return scheduleResponseDtoList;
    }

    @GetMapping("/sget")
    public ScheduleResponseDto getScheduleById(@RequestBody Long id){
        if(scheduleList.containsKey(id)){
            Schedule schedule = scheduleList.get(id);
            ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
            return scheduleResponseDto;
        } else {
            throw new IllegalArgumentException("존재하지 않는 일정입니다.");
        }
    }

    @PutMapping("/sput")
    public ScheduleResponseDto updateTodo(@RequestBody Long id, @RequestBody Long password, @RequestBody ScheduleUpdateRequestDto requestDto){
        if(scheduleList.containsKey(id)){
            Schedule schedule = scheduleList.get(id);
            if(schedule.getPassword().equals(password)){
                schedule.update(requestDto);
                ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
                return scheduleResponseDto;
            }
            else{
                throw new IllegalArgumentException("비밀번호가 다릅니다.");
            }
        }
        else{
            throw new IllegalArgumentException("존재하지 않는 일정입니다.");
        }
    }

    @DeleteMapping("/sdelete")
    public Long deleteSchedule(@PathVariable Long id){
        if(scheduleList.containsKey(id)){
            scheduleList.remove(id);
            return id;
        }
        else{
            throw new IllegalArgumentException("선택한 스케줄은 존재하지 않습니다.");
        }
    }

}

