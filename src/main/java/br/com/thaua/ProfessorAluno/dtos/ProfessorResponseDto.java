package br.com.thaua.ProfessorAluno.dtos;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorResponseDto{
    private Long id;
    private String nome;
    private Integer idade;
    private List<CursoResponseDto> cursos;

}
