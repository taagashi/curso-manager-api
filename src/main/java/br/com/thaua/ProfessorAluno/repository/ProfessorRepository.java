package br.com.thaua.ProfessorAluno.repository;

import br.com.thaua.ProfessorAluno.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {
}
