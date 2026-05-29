package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraAreaQuadradoTest {

  @Test
  void deveCalcularAreaDoQuadrado() {
    var area = CalculadoraAreaQuadrado.calcular(5.0);

    assertEquals(25.0, area);
  }

  @Test
  void deveRejeitarLadoZero() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> CalculadoraAreaQuadrado.calcular(0));

    assertEquals("O lado do quadrado deve ser maior que zero.", exception.getMessage());
  }

  @Test
  void deveRejeitarLadoNegativo() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> CalculadoraAreaQuadrado.calcular(-5));

    assertEquals("O lado do quadrado deve ser maior que zero.", exception.getMessage());
  }
}