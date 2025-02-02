package br.com.thaua.ProfessorAluno.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoRequestDto {
    private String nome;
    private Integer quantidadeHoras;
    private Long idDocente;

}
