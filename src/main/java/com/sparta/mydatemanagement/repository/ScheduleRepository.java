package com.sparta.mydatemanagement.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Schedule save(Schedule schedule) {
        if (schedule.getId() == null){
            String sql = "INSERT INTO schedules (task, manager, password, first_date, last_date) VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, schedule.getTask(), schedule.getManager(), schedule.getPassword(), schedule.getFirst_Date(), schedule.getLast_Date());

            Long id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
            schedule.setId(id);
            return schedule;
        }
    }

    public Optional<Schedule>
}
