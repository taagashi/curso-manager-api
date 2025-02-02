package br.com.thaua.ProfessorAluno.repository;

import br.com.thaua.ProfessorAluno.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
}
