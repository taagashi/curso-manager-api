package br.com.thaua.ProfessorAluno.converter;

import br.com.thaua.ProfessorAluno.dtos.*;
import br.com.thaua.ProfessorAluno.entity.CursoEntity;
import br.com.thaua.ProfessorAluno.entity.ProfessorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapperDtoEntity {
    MapperDtoEntity INSTANCE = Mappers.getMapper(MapperDtoEntity.class);

    @Mapping(target = "nomeDocente", expression = "java(cursoEntity.getDocente().getNome())")
    CursoResponseDto cursoEntityToCursoResponseDto(CursoEntity cursoEntity);
    CursoResponseSemProfDto CursoEntityToCursoResponseSemProfDto(CursoEntity cursoEntity);
    CursoRequestDto cursoEntityToCursoRequestDto(CursoEntity cursoEntity);

    ProfessorResponseDto professorEntityToProfessorResponseDto(ProfessorEntity professorEntity);
    ProfessorRequestDto professorEntityToProfessorRequestDto(ProfessorEntity professorEntity);

    CursoEntity toCursoEntity(CursoRequestDto cursoRequestDto);
    CursoEntity toCursoEntity(CursoResponseDto cursoResponseDto);

    ProfessorEntity toProfessorEntity(ProfessorRequestDto professorRequestDto);
    ProfessorEntity toProfessorEntity(ProfessorResponseDto professorResponseDto);


    CursoResponseDto cursoRequestDtoToCursoResponseDto(CursoRequestDto cursoRequestDto);
    CursoRequestDto cursoResponseDtoToCursoRequestDto(CursoResponseDto cursoResponseDto);

    ProfessorResponseDto professorRequestDtoToProfessorResponseDto(ProfessorRequestDto professorRequestDto);
    ProfessorRequestDto professorResponseDtoToProfessorRequestDto(ProfessorResponseDto professorResponseDto);

}
