package br.com.marceloreisfernandes.bootcamp.poo.geometria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RetanguloTest {

  private static final double DELTA = 0.001;

  @Test
  void deveSerFiguraGeometrica() {
    assertInstanceOf(FiguraGeometrica.class, new Retangulo(4.0, 6.0));
  }

  @Test
  void deveCalcularAreaDoRetangulo() {
    var retangulo = new Retangulo(4.0, 6.0);

    assertEquals(24.0, retangulo.calcularArea(), DELTA);
  }

  @Test
  void deveRejeitarBaseZeroOuNegativa() {
    assertThrows(IllegalArgumentException.class, () -> new Retangulo(0, 6.0));
    assertThrows(IllegalArgumentException.class, () -> new Retangulo(-1.0, 6.0));
  }

  @Test
  void deveRejeitarAlturaZeroOuNegativa() {
    assertThrows(IllegalArgumentException.class, () -> new Retangulo(4.0, 0));
    assertThrows(IllegalArgumentException.class, () -> new Retangulo(4.0, -1.0));
  }
}
