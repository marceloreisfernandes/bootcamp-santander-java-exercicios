package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClassificadorImcTest {

  @Test
  void deveClassificarAbaixoDoPeso() {
    String classificacao = ClassificadorImc.classificar(18.5);

    assertEquals("Abaixo do peso", classificacao);
  }

  @Test
  void deveClassificarPesoIdeal() {
    String classificacao = ClassificadorImc.classificar(24.9);

    assertEquals("Peso ideal", classificacao);
  }

  @Test
  void deveClassificarLevementeAcimaDoPeso() {
    String classificacao = ClassificadorImc.classificar(29.9);

    assertEquals("Levemente acima do peso", classificacao);
  }

  @Test
  void deveClassificarObesidadeGrauUm() {
    String classificacao = ClassificadorImc.classificar(34.9);

    assertEquals("Obesidade Grau I", classificacao);
  }

  @Test
  void deveClassificarObesidadeGrauDois() {
    String classificacao = ClassificadorImc.classificar(39.9);

    assertEquals("Obesidade Grau II", classificacao);
  }

  @Test
  void deveClassificarObesidadeGrauTres() {
    String classificacao = ClassificadorImc.classificar(40.0);

    assertEquals("Obesidade Grau III", classificacao);
  }

  @Test
  void deveRejeitarImcZero() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> ClassificadorImc.classificar(0));

    assertEquals("O IMC deve ser maior que zero.", exception.getMessage());
  }

  @Test
  void deveRejeitarImcNegativo() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> ClassificadorImc.classificar(-1));

    assertEquals("O IMC deve ser maior que zero.", exception.getMessage());
  }
}
