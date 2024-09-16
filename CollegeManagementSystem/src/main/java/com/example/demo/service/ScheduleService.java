package com.example.demo.service;

import com.example.demo.model.Schedule;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface ScheduleService {
    Schedule createSchedule(Schedule schedule);
    Schedule getScheduleById(Long id) throws ResourceNotFoundException;
    List<Schedule> getAllSchedules();
    Schedule updateSchedule(Long id, Schedule schedule) throws ResourceNotFoundException;
    void deleteSchedule(Long id) throws ResourceNotFoundException;
}
