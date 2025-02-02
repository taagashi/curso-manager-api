package br.com.thaua.ProfessorAluno.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoResponseDto {
    private Long id;
    private String nome;
    private Integer quantidadeHoras;
    private ProfessorResponseDto docente;
}
