package com.example.demo.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Builder
public class ClubDto {

    private Long id;
    @NotEmpty(message = "Titulo do Clube não pode ficar vazio")
    private String titulo;
    @NotEmpty(message = "URL da foto não pode ficar vazia")
    private String fotoUrl;
    @NotEmpty(message = "Conteúdo não pode ficar vazio")
    private String conteudo;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

}
