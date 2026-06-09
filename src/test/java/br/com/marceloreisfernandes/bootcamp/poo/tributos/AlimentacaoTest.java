package br.com.marceloreisfernandes.bootcamp.poo.tributos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AlimentacaoTest {

  private static final double DELTA = 0.001;

  @Test
  void deveSerProdutoTributavel() {
    assertInstanceOf(ProdutoTributavel.class, new Alimentacao(100.0));
  }

  @Test
  void deveCalcularImpostoDeUmPorCento() {
    var alimentacao = new Alimentacao(100.0);

    assertEquals(1.0, alimentacao.calcularImposto(), DELTA);
  }

  @Test
  void deveCalcularImpostoZeroQuandoValorForZero() {
    var alimentacao = new Alimentacao(0);

    assertEquals(0, alimentacao.calcularImposto(), DELTA);
  }

  @Test
  void deveRejeitarValorNegativo() {
    var exception = assertThrows(IllegalArgumentException.class, () -> new Alimentacao(-1.0));

    assertEquals("O valor do produto não pode ser negativo.", exception.getMessage());
  }
}
