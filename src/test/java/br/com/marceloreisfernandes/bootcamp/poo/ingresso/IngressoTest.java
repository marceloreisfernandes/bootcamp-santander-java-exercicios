package br.com.marceloreisfernandes.bootcamp.poo.ingresso;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IngressoTest {

  private static final double DELTA = 0.001;

  @Test
  void deveCriarIngressoComValorNomeFilmeETipoAudio() {
    Ingresso ingresso = new Ingresso(40.0, "Matrix", true);

    assertEquals(40.0, ingresso.getValor(), DELTA);
    assertEquals("Matrix", ingresso.getNomeFilme());
    assertTrue(ingresso.isDublado());
  }

  @Test
  void deveCriarIngressoLegendado() {
    Ingresso ingresso = new Ingresso(40.0, "Matrix", false);

    assertFalse(ingresso.isDublado());
  }

  @Test
  void deveRetornarValorBaseComoValorReal() {
    Ingresso ingresso = new Ingresso(40.0, "Matrix", true);

    assertEquals(40.0, ingresso.getValorReal(), DELTA);
  }

  @Test
  void deveRemoverEspacosDoNomeDoFilme() {
    Ingresso ingresso = new Ingresso(40.0, " Matrix ", true);

    assertEquals("Matrix", ingresso.getNomeFilme());
  }

  @Test
  void deveRejeitarValorZeroOuNegativo() {
    assertThrows(IllegalArgumentException.class, () -> new Ingresso(0, "Matrix", true));
    assertThrows(IllegalArgumentException.class, () -> new Ingresso(-1, "Matrix", true));
  }

  @Test
  void deveRejeitarNomeFilmeNuloOuVazio() {
    assertThrows(IllegalArgumentException.class, () -> new Ingresso(40.0, null, true));
    assertThrows(IllegalArgumentException.class, () -> new Ingresso(40.0, "", true));
    assertThrows(IllegalArgumentException.class, () -> new Ingresso(40.0, "   ", true));
  }
}
