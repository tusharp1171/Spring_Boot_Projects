package com.example.demo.service;
import java.util.List;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Event;

public interface EventService {
    Event createEvent(Event event);
    Event getEventById(Long id) throws ResourceNotFoundException;
    List<Event> getAllEvents();
    Event updateEvent(Long id, Event event) throws ResourceNotFoundException;
    void deleteEvent(Long id) throws ResourceNotFoundException;
}