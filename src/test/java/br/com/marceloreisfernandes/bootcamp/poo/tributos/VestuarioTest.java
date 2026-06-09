package br.com.marceloreisfernandes.bootcamp.poo.tributos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VestuarioTest {

  private static final double DELTA = 0.001;

  @Test
  void deveSerProdutoTributavel() {
    assertInstanceOf(ProdutoTributavel.class, new Vestuario(100.0));
  }

  @Test
  void deveCalcularImpostoDeDoisEMeioPorCento() {
    var vestuario = new Vestuario(100.0);

    assertEquals(2.5, vestuario.calcularImposto(), DELTA);
  }

  @Test
  void deveCalcularImpostoZeroQuandoValorForZero() {
    var vestuario = new Vestuario(0);

    assertEquals(0, vestuario.calcularImposto(), DELTA);
  }

  @Test
  void deveRejeitarValorNegativo() {
    var exception = assertThrows(IllegalArgumentException.class, () -> new Vestuario(-1.0));

    assertEquals("O valor do produto não pode ser negativo.", exception.getMessage());
  }
}
