package com.example.demo.service.implement;

import com.example.demo.dto.EventDto;
import com.example.demo.models.Club;
import com.example.demo.models.Event;
import com.example.demo.repository.ClubRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.example.demo.mapper.EventMapper.mapToEvent;

@Service
public class EventServiceImplement implements EventService {

    private EventRepository eventRepository;

    private ClubRepository clubRepository;


    public EventServiceImplement(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }


}
