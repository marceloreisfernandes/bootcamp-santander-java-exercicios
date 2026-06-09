package br.com.marceloreisfernandes.bootcamp.poo.geometria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CirculoTest {

  private static final double DELTA = 0.001;

  @Test
  void deveSerFiguraGeometrica() {
    assertInstanceOf(FiguraGeometrica.class, new Circulo(3.0));
  }

  @Test
  void deveCalcularAreaDoCirculo() {
    var circulo = new Circulo(3.0);

    assertEquals(Math.PI * 9.0, circulo.calcularArea(), DELTA);
  }

  @Test
  void deveRejeitarRaioZeroOuNegativo() {
    assertThrows(IllegalArgumentException.class, () -> new Circulo(0));
    assertThrows(IllegalArgumentException.class, () -> new Circulo(-1.0));
  }
}
