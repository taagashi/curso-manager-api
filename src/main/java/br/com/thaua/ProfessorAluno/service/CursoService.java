package br.com.thaua.ProfessorAluno.service;

import br.com.thaua.ProfessorAluno.converter.MapperDtoEntity;
import br.com.thaua.ProfessorAluno.dtos.CursoRequestDto;
import br.com.thaua.ProfessorAluno.dtos.CursoResponseDto;
import br.com.thaua.ProfessorAluno.dtos.ProfessorResponseDto;
import br.com.thaua.ProfessorAluno.entity.CursoEntity;
import br.com.thaua.ProfessorAluno.entity.ProfessorEntity;
import br.com.thaua.ProfessorAluno.repository.CursoRepository;
import br.com.thaua.ProfessorAluno.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CursoService {
    private CursoRepository cursoRepository;
    private ProfessorRepository professorRepository;

    public CursoResponseDto adicionarCurso(CursoRequestDto cursoRequestDto)
    {
        ProfessorEntity professorEntity = professorRepository.findById(cursoRequestDto.getIdDocente()).orElse(null);

        if(professorEntity == null) {return null;}

        CursoEntity cursoEntity = MapperDtoEntity.INSTANCE.toCursoEntity(cursoRequestDto);
        cursoEntity.setDocente(professorEntity);

        CursoResponseDto cursoResponseDto = MapperDtoEntity.INSTANCE.cursoEntityToCursoResponseDto(cursoRepository.save(cursoEntity));

        cursoResponseDto.setNomeDocente(professorEntity.getNome());

        return cursoResponseDto;
    }

    public CursoResponseDto buscarCursoPeloId(Long id)
    {
        CursoEntity cursoEntity = cursoRepository.findById(id).orElse(null);
        return MapperDtoEntity.INSTANCE.cursoEntityToCursoResponseDto(cursoEntity);
    }
}
