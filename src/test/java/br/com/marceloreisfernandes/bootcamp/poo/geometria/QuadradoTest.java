package br.com.marceloreisfernandes.bootcamp.poo.geometria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuadradoTest {

  private static final double DELTA = 0.001;

  @Test
  void deveSerFiguraGeometrica() {
    assertInstanceOf(FiguraGeometrica.class, new Quadrado(4.0));
  }

  @Test
  void deveCalcularAreaDoQuadrado() {
    var quadrado = new Quadrado(4.0);

    assertEquals(16.0, quadrado.calcularArea(), DELTA);
  }

  @Test
  void deveRejeitarLadoZeroOuNegativo() {
    assertThrows(IllegalArgumentException.class, () -> new Quadrado(0));
    assertThrows(IllegalArgumentException.class, () -> new Quadrado(-1.0));
  }
}
