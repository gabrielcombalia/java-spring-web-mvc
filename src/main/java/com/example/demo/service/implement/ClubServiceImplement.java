package com.example.demo.service.implement;

import com.example.demo.dto.ClubDto;
import com.example.demo.models.Club;
import com.example.demo.repository.ClubRepository;
import com.example.demo.service.ClubService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.mapper.ClubMapper.mapToClub;
import static com.example.demo.mapper.ClubMapper.mapToClubDto;

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

    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(Long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.save(club);
    }

    @Override
    public void delete(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

}
