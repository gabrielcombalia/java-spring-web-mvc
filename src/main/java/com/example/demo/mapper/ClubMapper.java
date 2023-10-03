package com.example.demo.mapper;

import com.example.demo.dto.ClubDto;
import com.example.demo.models.Club;

import java.util.stream.Collectors;

import static com.example.demo.mapper.EventMapper.mapToEventDto;

public class ClubMapper {

    public static Club mapToClub(ClubDto club) {
        Club clubDto = Club.builder()
                .id(club.getId())
                .titulo(club.getTitulo())
                .conteudo(club.getConteudo())
                .fotoUrl(club.getFotoUrl())
                .criadoEm(club.getCriadoEm())
                .atualizadoEm(club.getAtualizadoEm())
                .build();
        return clubDto;
    }

    public static ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .titulo(club.getTitulo())
                .conteudo(club.getConteudo())
                .fotoUrl(club.getFotoUrl())
                .criadoEm(club.getCriadoEm())
                .atualizadoEm(club.getAtualizadoEm())
                .events(club.getEvents().stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList()))
                .build();
        return clubDto;
    }
}
