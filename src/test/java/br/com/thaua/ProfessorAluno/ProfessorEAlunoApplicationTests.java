package br.com.thaua.ProfessorAluno;

import br.com.thaua.ProfessorAluno.converter.MapperDtoEntity;
import br.com.thaua.ProfessorAluno.dtos.ProfessorRequestDto;
import br.com.thaua.ProfessorAluno.dtos.ProfessorResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProfessorEAlunoApplicationTests {

	@Test
	public void testMappingAutomatico() {
		ProfessorRequestDto request = new ProfessorRequestDto("Fulano de Tal", 40);
		ProfessorResponseDto response = MapperDtoEntity.INSTANCE.professorRequestDtoToProfessorResponseDto(request);

		// Esses valores devem ser mapeados automaticamente
		assertEquals("Fulano de Tal", response.getNome());
		assertEquals(40, response.getIdade());
	}


}
