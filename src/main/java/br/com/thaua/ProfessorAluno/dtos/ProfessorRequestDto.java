package br.com.thaua.ProfessorAluno.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorRequestDto {
    private String nome;
    private Integer idade;
}
