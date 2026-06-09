package br.com.marceloreisfernandes.bootcamp.poo.tributos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SaudeBemEstarTest {

  private static final double DELTA = 0.001;

  @Test
  void deveSerProdutoTributavel() {
    assertInstanceOf(ProdutoTributavel.class, new SaudeBemEstar(100.0));
  }

  @Test
  void deveCalcularImpostoDeUmEMeioPorCento() {
    var saudeBemEstar = new SaudeBemEstar(100.0);

    assertEquals(1.5, saudeBemEstar.calcularImposto(), DELTA);
  }

  @Test
  void deveCalcularImpostoZeroQuandoValorForZero() {
    var saudeBemEstar = new SaudeBemEstar(0);

    assertEquals(0, saudeBemEstar.calcularImposto(), DELTA);
  }

  @Test
  void deveRejeitarValorNegativo() {
    var exception = assertThrows(IllegalArgumentException.class, () -> new SaudeBemEstar(-1.0));

    assertEquals("O valor do produto não pode ser negativo.", exception.getMessage());
  }
}
