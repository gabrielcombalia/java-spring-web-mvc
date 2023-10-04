package com.example.demo.service.implement;

import com.example.demo.dto.EventDto;
import com.example.demo.models.Club;
import com.example.demo.models.Event;
import com.example.demo.repository.ClubRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.mapper.ClubMapper.mapToClub;
import static com.example.demo.mapper.EventMapper.mapToEvent;
import static com.example.demo.mapper.EventMapper.mapToEventDto;

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

    @Override
    public EventDto findByEventId(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events =  eventRepository.findAll();
        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        Event event = mapToEvent(eventDto);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }


}
