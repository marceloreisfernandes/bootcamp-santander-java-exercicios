package br.com.marceloreisfernandes.bootcamp.poo.tributos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CulturaTest {

  private static final double DELTA = 0.001;

  @Test
  void deveSerProdutoTributavel() {
    assertInstanceOf(ProdutoTributavel.class, new Cultura(100.0));
  }

  @Test
  void deveCalcularImpostoDeQuatroPorCento() {
    var cultura = new Cultura(100.0);

    assertEquals(4.0, cultura.calcularImposto(), DELTA);
  }

  @Test
  void deveCalcularImpostoZeroQuandoValorForZero() {
    var cultura = new Cultura(0);

    assertEquals(0, cultura.calcularImposto(), DELTA);
  }

  @Test
  void deveRejeitarValorNegativo() {
    var exception = assertThrows(IllegalArgumentException.class, () -> new Cultura(-1.0));

    assertEquals("O valor do produto não pode ser negativo.", exception.getMessage());
  }
}
