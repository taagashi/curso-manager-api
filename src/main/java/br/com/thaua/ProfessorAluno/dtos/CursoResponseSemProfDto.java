package br.com.thaua.ProfessorAluno.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoResponseSemProfDto {
    private Long id;
    private String nome;
    private Integer quantidadeHoras;
}
