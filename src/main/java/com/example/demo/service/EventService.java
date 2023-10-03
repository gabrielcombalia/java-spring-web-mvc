package com.example.demo.service;

import com.example.demo.dto.EventDto;

public interface EventService {

    void createEvent(Long clubId, EventDto eventDto);

}
