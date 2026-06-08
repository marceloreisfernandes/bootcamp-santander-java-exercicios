package br.com.marceloreisfernandes.bootcamp.poo.ingresso;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MeiaEntradaTest {

  private static final double DELTA = 0.001;

  @Test
  void deveSerUmIngresso() {
    MeiaEntrada meiaEntrada = new MeiaEntrada(40.0, "Matrix", true);

    assertInstanceOf(Ingresso.class, meiaEntrada);
  }

  @Test
  void deveRetornarMetadeDoValorComoValorReal() {
    MeiaEntrada meiaEntrada = new MeiaEntrada(40.0, "Matrix", true);

    assertEquals(20.0, meiaEntrada.getValorReal(), DELTA);
  }

  @Test
  void deveManterDadosDoIngresso() {
    MeiaEntrada meiaEntrada = new MeiaEntrada(40.0, "Matrix", true);

    assertEquals(40.0, meiaEntrada.getValor(), DELTA);
    assertEquals("Matrix", meiaEntrada.getNomeFilme());
  }

  @Test
  void deveRejeitarDadosInvalidos() {
    assertThrows(IllegalArgumentException.class, () -> new MeiaEntrada(0, "Matrix", true));
    assertThrows(IllegalArgumentException.class, () -> new MeiaEntrada(40.0, "", true));
  }
}
