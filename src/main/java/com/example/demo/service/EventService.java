package com.example.demo.service;

import com.example.demo.dto.EventDto;

import java.util.List;

public interface EventService {

    void createEvent(Long clubId, EventDto eventDto);

    EventDto findByEventId(Long eventId);

    List<EventDto> findAllEvents();

    void updateEvent(EventDto eventDto);

    void deleteEvent(Long eventId);
}
