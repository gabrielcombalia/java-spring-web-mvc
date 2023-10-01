package com.example.demo.dto;


import lombok.Builder;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Builder
public class ClubDto {

    private Long id;
    private String titulo;
    private String fotoUrl;
    private String conteudo;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

}
