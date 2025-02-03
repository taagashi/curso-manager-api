package br.com.thaua.ProfessorAluno.controller;

import br.com.thaua.ProfessorAluno.dtos.CursoRequestDto;
import br.com.thaua.ProfessorAluno.dtos.CursoResponseDto;
import br.com.thaua.ProfessorAluno.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Tag(name = "cursos", description = "api de gerenciamento de cursos")
@RestController
@RequestMapping("/curso")
public class CursoController {
    private CursoService cursoService;

    @Operation(summary = "adiciona um curso", description = "adiciona um cuso passando o nome, quantidade de horas e id do professor",
                responses = {@ApiResponse(responseCode = "200", description = "curso adicionado com sucesso"),
                            @ApiResponse(responseCode = "400", description = "erro ao tentar adicionar curso")})
    @PostMapping
    public ResponseEntity<CursoResponseDto> adicionarCurso(@RequestBody CursoRequestDto cursoRequestDto)
    {
        return ResponseEntity.ok(cursoService.adicionarCurso(cursoRequestDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar curso", description = "busca cursos atraves do id", responses = {
                @ApiResponse(responseCode = "200", description = "curso encontrado com sucesso"),
                @ApiResponse(responseCode = "400", description = "nao foi possivel encontrar curso com esse id")
    })
    public ResponseEntity<CursoResponseDto> buscarCurso(Long id)
    {
        return ResponseEntity.ok(cursoService.buscarCursoPeloId(id));
    }
}
