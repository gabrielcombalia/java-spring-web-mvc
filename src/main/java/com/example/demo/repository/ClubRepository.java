package com.example.demo.repository;

import com.example.demo.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {

    Optional<Club> findByTitulo(String url);

    @Query("SELECT c FROM Club c WHERE c.titulo LIKE CONCAT('%', :query, '%')")
    List<Club> searchClubs(String query);

}
