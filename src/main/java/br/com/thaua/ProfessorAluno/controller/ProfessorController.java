package br.com.thaua.ProfessorAluno.controller;

import br.com.thaua.ProfessorAluno.dtos.ProfessorRequestDto;
import br.com.thaua.ProfessorAluno.dtos.ProfessorResponseDto;
import br.com.thaua.ProfessorAluno.paginacao.Pagina;
import br.com.thaua.ProfessorAluno.service.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@Tag(name = "professores", description = "api de gerenciamento de professores")
@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private ProfessorService professorService;

    @Operation(summary = "adicionar Professor", description = "Adiciona professor pegando o objeto do corpo da requisicao",
                responses = {@ApiResponse(responseCode = "200", description = "professor adicionado com sucesso"),
                             @ApiResponse(responseCode = "400", description = "erro ao tentar adicionar professor")})
    @PostMapping
    public ResponseEntity<ProfessorResponseDto> adicionarProfessor(@RequestBody ProfessorRequestDto professorRequestDto)
    {
        return ResponseEntity.ok(professorService.adicionarProfessor(professorRequestDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar professor", description = "Realiza busca de professor pelo id dele",
                responses = {@ApiResponse(responseCode = "200", description = "professor encontrado com sucesso"),
                            @ApiResponse(responseCode = "500", description = "erro ao tentar buscar pelo professor com esse id")})
    public ResponseEntity<ProfessorResponseDto> buscarProfessor(@PathVariable Long id)
    {
      return ResponseEntity.ok(professorService.buscarProfessorPorId(id));
    }

    @GetMapping("/exibir")
    @Operation(summary = "Exibir professores", description = "Exibe os professores atraves de paginacao", responses = {
                @ApiResponse(responseCode = "200", description = "exibicao realiada com sucesso"),
                @ApiResponse(responseCode = "400", description = "erro ao tentar exibir professores")
    })
    public ResponseEntity<Pagina<ProfessorResponseDto>> exibirProfessores(@ParameterObject @PageableDefault(size = 2)Pageable pageable)
    {
        return ResponseEntity.ok(professorService.exibirProfessores(pageable));
    }
}
