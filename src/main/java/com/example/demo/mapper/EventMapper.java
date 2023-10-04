package com.example.demo.mapper;

import com.example.demo.dto.EventDto;
import com.example.demo.models.Event;
public class EventMapper {
    public static Event mapToEvent(EventDto eventDto) {

        return Event.builder()
                .id(eventDto.getId())
                .nome(eventDto.getNome())
                .inicioEvento(eventDto.getInicioEvento())
                .fimEvento(eventDto.getFimEvento())
                .tipo(eventDto.getTipo())
                .fotoUrl(eventDto.getFotoUrl())
                .criadoEm(eventDto.getCriadoEm())
                .atualizadoEm(eventDto.getAtualizadoEm())
                .club(eventDto.getClub())
                .build();




    }

    public static EventDto mapToEventDto(Event event) {

        return EventDto.builder()
                .id(event.getId())
                .nome(event.getNome())
                .inicioEvento(event.getInicioEvento())
                .fimEvento(event.getFimEvento())
                .tipo(event.getTipo())
                .fotoUrl(event.getFotoUrl())
                .criadoEm(event.getCriadoEm())
                .atualizadoEm(event.getAtualizadoEm())
                .club(event.getClub())
                .build();




    }



}
