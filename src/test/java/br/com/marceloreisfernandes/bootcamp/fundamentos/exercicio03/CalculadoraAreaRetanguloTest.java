package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraAreaRetanguloTest {

  @Test
  void deveCalcularAreaDoRetangulo() {
    var area = CalculadoraAreaRetangulo.calcular(10.0, 5.0);

    assertEquals(50.0, area);
  }

  @Test
  void deveRejeitarBaseZero() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> CalculadoraAreaRetangulo.calcular(0, 5.0));

    assertEquals("A base do retângulo deve ser maior que zero.", exception.getMessage());
  }

  @Test
  void deveRejeitarAlturaZero() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> CalculadoraAreaRetangulo.calcular(10.0, 0));

    assertEquals("A altura do retângulo deve ser maior que zero.", exception.getMessage());
  }
}
