package br.com.thaua.ProfessorAluno.service;

import br.com.thaua.ProfessorAluno.converter.MapperDtoEntity;
import br.com.thaua.ProfessorAluno.dtos.ProfessorRequestDto;
import br.com.thaua.ProfessorAluno.dtos.ProfessorResponseDto;
import br.com.thaua.ProfessorAluno.entity.ProfessorEntity;
import br.com.thaua.ProfessorAluno.paginacao.Pagina;
import br.com.thaua.ProfessorAluno.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfessorService {
    private ProfessorRepository professorRepository;

    public ProfessorResponseDto adicionarProfessor(ProfessorRequestDto professorRequestDto)
    {
        ProfessorEntity professorEntity = professorRepository.save(MapperDtoEntity.INSTANCE.toProfessorEntity(professorRequestDto));
        return MapperDtoEntity.INSTANCE.professorEntityToProfessorResponseDto(professorEntity);
    }

    public ProfessorResponseDto buscarProfessorPorId(Long id)
    {
        ProfessorEntity professorEntity = professorRepository.findById(id).orElse(null);
        return MapperDtoEntity.INSTANCE.professorEntityToProfessorResponseDto(professorEntity);
    }

    public Pagina<ProfessorResponseDto> exibirProfessores(Pageable pageable)
    {
         Page<ProfessorResponseDto> page = professorRepository.findAll(pageable).map(MapperDtoEntity.INSTANCE::professorEntityToProfessorResponseDto);
         return new Pagina<>(page);
    }
}
