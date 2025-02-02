package br.com.thaua.ProfessorAluno;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "curso-manager-api",
				description = "API de gerenciamento de cursos, tendo relacionamento entre os cursos e os professores",
				version = "1.0"
		)
)
public class ProfessorEAlunoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfessorEAlunoApplication.class, args);
	}

}
