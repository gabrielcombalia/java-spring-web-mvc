package com.example.demo.service.implement;

import com.example.demo.dto.ClubDto;
import com.example.demo.models.Club;
import com.example.demo.repository.ClubRepository;
import com.example.demo.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImplement implements ClubService {

    public ClubServiceImplement(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    private ClubRepository clubRepository;
    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

    private ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .titulo(club.getTitulo())
                .conteudo(club.getConteudo())
                .fotoUrl(club.getFotoUrl())
                .criadoEm(club.getCriadoEm())
                .atualizadoEm(club.getAtualizadoEm())
                .build();
        return clubDto;
    }
}
