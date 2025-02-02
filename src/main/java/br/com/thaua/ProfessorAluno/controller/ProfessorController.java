package br.com.thaua.ProfessorAluno.controller;

import br.com.thaua.ProfessorAluno.converter.MapperDtoEntity;
import br.com.thaua.ProfessorAluno.dtos.ProfessorRequestDto;
import br.com.thaua.ProfessorAluno.dtos.ProfessorResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "professores", description = "api de gerenciamento de professores")
@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Operation(summary = "adicionar Professor", description = "Adiciona professor pegando o objeto do corpo da requisicao",
                responses = {@ApiResponse(responseCode = "200", description = "professor adicionado com sucesso"),
                             @ApiResponse(responseCode = "400", description = "erro ao tentar adicionar professor")})
    @PostMapping
    public ResponseEntity<ProfessorResponseDto> adicionarProfessor(@RequestBody ProfessorRequestDto professorRequestDto)
    {
        System.out.println(professorRequestDto);
        ProfessorResponseDto professorResponseDto = MapperDtoEntity.INSTANCE.professorRequestDtoToProfessorResponseDto(professorRequestDto);
        System.out.println(professorResponseDto);
        return ResponseEntity.ok(professorResponseDto);
    }
}
