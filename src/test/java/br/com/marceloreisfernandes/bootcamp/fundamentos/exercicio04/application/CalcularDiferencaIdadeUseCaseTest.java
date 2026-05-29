package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio04.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcularDiferencaIdadeUseCaseTest {

  @Test
  void deveCalcularDiferencaDeIdade() {
    var useCase = new CalcularDiferencaIdadeUseCase();

    var diferencaIdade = useCase.executar("Marcelo", 40, "Ana", 13);

    assertEquals(27, diferencaIdade);
  }

  @Test
  void deveAplicarValidacaoDeNome() {
    var useCase = new CalcularDiferencaIdadeUseCase();

    var exception = assertThrows(IllegalArgumentException.class,
        () -> useCase.executar("", 40, "Ana", 13));

    assertEquals("O nome da pessoa não pode ser vazio.", exception.getMessage());
  }

  @Test
  void deveAplicarValidacaoDeIdade() {
    var useCase = new CalcularDiferencaIdadeUseCase();

    var exception = assertThrows(IllegalArgumentException.class,
        () -> useCase.executar("Marcelo", -1, "Ana", 13));

    assertEquals("A idade da pessoa não pode ser negativa.", exception.getMessage());
  }
}
