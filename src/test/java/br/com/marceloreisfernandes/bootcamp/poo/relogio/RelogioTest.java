package br.com.marceloreisfernandes.bootcamp.poo.relogio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RelogioTest {

  @Test
  void deveAlterarHoraMinutoESegundo() {
    Relogio relogio = new RelogioBrasileiro();

    relogio.setHora(13);
    relogio.setMinuto(5);
    relogio.setSegundo(9);

    assertEquals(13, relogio.getHora());
    assertEquals(5, relogio.getMinuto());
    assertEquals(9, relogio.getSegundo());
  }

  @Test
  void deveFormatarHoraComDoisDigitos() {
    Relogio relogio = new RelogioBrasileiro();
    relogio.setHora(3);
    relogio.setMinuto(5);
    relogio.setSegundo(9);

    assertEquals("03:05:09", relogio.getHoraFormatada());
  }

  @Test
  void deveRejeitarMinutoInvalido() {
    Relogio relogio = new RelogioBrasileiro();

    assertThrows(IllegalArgumentException.class, () -> relogio.setMinuto(-1));
    assertThrows(IllegalArgumentException.class, () -> relogio.setMinuto(60));
  }

  @Test
  void deveRejeitarSegundoInvalido() {
    Relogio relogio = new RelogioBrasileiro();

    assertThrows(IllegalArgumentException.class, () -> relogio.setSegundo(-1));
    assertThrows(IllegalArgumentException.class, () -> relogio.setSegundo(60));
  }
}
