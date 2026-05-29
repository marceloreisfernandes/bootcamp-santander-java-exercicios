package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio04.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDiferencaIdadeTest {

  @Test
  void deveCalcularDiferencaDeIdadeQuandoPrimeiraPessoaForMaisVelha() {
    var primeiraPessoa = new Pessoa("Marcelo", 40);
    var segundaPessoa = new Pessoa("Ana", 13);

    var diferencaIdade = CalculadoraDiferencaIdade.calcular(primeiraPessoa, segundaPessoa);

    assertEquals(27, diferencaIdade);
  }

  @Test
  void deveCalcularDiferencaDeIdadeQuandoSegundaPessoaForMaisVelha() {
    var primeiraPessoa = new Pessoa("Ana", 13);
    var segundaPessoa = new Pessoa("Marcelo", 40);

    var diferencaIdade = CalculadoraDiferencaIdade.calcular(primeiraPessoa, segundaPessoa);

    assertEquals(27, diferencaIdade);
  }

  @Test
  void deveRejeitarNomeNulo() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> new Pessoa(null, 40));

    assertEquals("O nome da pessoa não pode ser vazio.", exception.getMessage());
  }

  @Test
  void deveRejeitarNomeVazio() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> new Pessoa(" ", 40));

    assertEquals("O nome da pessoa não pode ser vazio.", exception.getMessage());
  }

  @Test
  void deveRejeitarIdadeNegativa() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> new Pessoa("Marcelo", -1));

    assertEquals("A idade da pessoa não pode ser negativa.", exception.getMessage());
  }

  @Test
  void deveRejeitarPessoaNula() {
    var pessoa = new Pessoa("Marcelo", 40);

    var exception = assertThrows(IllegalArgumentException.class,
        () -> CalculadoraDiferencaIdade.calcular(pessoa, null));

    assertEquals("As pessoas devem ser informadas.", exception.getMessage());
  }
}
