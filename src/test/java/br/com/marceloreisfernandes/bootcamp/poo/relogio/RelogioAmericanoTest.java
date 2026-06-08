package br.com.marceloreisfernandes.bootcamp.poo.relogio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RelogioAmericanoTest {

  @Test
  void deveSerUmRelogio() {
    RelogioAmericano relogioAmericano = new RelogioAmericano();

    assertInstanceOf(Relogio.class, relogioAmericano);
  }

  @Test
  void deveIniciarMeiaNoite() {
    RelogioAmericano relogioAmericano = new RelogioAmericano();

    assertEquals(12, relogioAmericano.getHora());
    assertEquals(RelogioAmericano.Periodo.AM, relogioAmericano.getPeriodo());
  }

  @Test
  void deveAceitarHoraEntreUmEDoze() {
    RelogioAmericano relogioAmericano = new RelogioAmericano();

    relogioAmericano.setHora(1);
    assertEquals(1, relogioAmericano.getHora());

    relogioAmericano.setHora(12);
    assertEquals(12, relogioAmericano.getHora());
  }

  @Test
  void deveRejeitarHoraInvalida() {
    RelogioAmericano relogioAmericano = new RelogioAmericano();

    assertThrows(IllegalArgumentException.class, () -> relogioAmericano.setHora(0));
    assertThrows(IllegalArgumentException.class, () -> relogioAmericano.setHora(13));
  }

  @Test
  void deveAlterarPeriodo() {
    RelogioAmericano relogioAmericano = new RelogioAmericano();

    relogioAmericano.setPeriodo(RelogioAmericano.Periodo.PM);

    assertEquals(RelogioAmericano.Periodo.PM, relogioAmericano.getPeriodo());
  }

  @Test
  void deveRejeitarPeriodoNulo() {
    RelogioAmericano relogioAmericano = new RelogioAmericano();

    assertThrows(IllegalArgumentException.class, () -> relogioAmericano.setPeriodo(null));
  }

  @Test
  void deveFormatarHoraComPeriodo() {
    RelogioAmericano relogioAmericano = new RelogioAmericano();
    relogioAmericano.setHora(1);
    relogioAmericano.setMinuto(5);
    relogioAmericano.setSegundo(9);
    relogioAmericano.setPeriodo(RelogioAmericano.Periodo.PM);

    assertEquals("01:05:09 PM", relogioAmericano.getHoraFormatada());
  }

  @Test
  void deveSincronizarComRelogioAmericano() {
    RelogioAmericano origem = new RelogioAmericano();
    origem.setHora(11);
    origem.setMinuto(58);
    origem.setSegundo(59);
    origem.setPeriodo(RelogioAmericano.Periodo.PM);
    RelogioAmericano destino = new RelogioAmericano();

    destino.sincronizar(origem);

    assertEquals("11:58:59 PM", destino.getHoraFormatada());
  }

  @Test
  void deveSincronizarMeiaNoiteDoRelogioBrasileiro() {
    RelogioBrasileiro origem = new RelogioBrasileiro();
    origem.setHora(0);
    RelogioAmericano destino = new RelogioAmericano();

    destino.sincronizar(origem);

    assertEquals(12, destino.getHora());
    assertEquals(RelogioAmericano.Periodo.AM, destino.getPeriodo());
  }

  @Test
  void deveSincronizarDezDaManhaDoRelogioBrasileiro() {
    RelogioBrasileiro origem = new RelogioBrasileiro();
    origem.setHora(10);
    RelogioAmericano destino = new RelogioAmericano();

    destino.sincronizar(origem);

    assertEquals(10, destino.getHora());
    assertEquals(RelogioAmericano.Periodo.AM, destino.getPeriodo());
  }

  @Test
  void deveSincronizarMeioDiaDoRelogioBrasileiro() {
    RelogioBrasileiro origem = new RelogioBrasileiro();
    origem.setHora(12);
    RelogioAmericano destino = new RelogioAmericano();

    destino.sincronizar(origem);

    assertEquals(12, destino.getHora());
    assertEquals(RelogioAmericano.Periodo.PM, destino.getPeriodo());
  }

  @Test
  void deveSincronizarUmaHoraDaTardeDoRelogioBrasileiro() {
    RelogioBrasileiro origem = new RelogioBrasileiro();
    origem.setHora(13);
    RelogioAmericano destino = new RelogioAmericano();

    destino.sincronizar(origem);

    assertEquals(1, destino.getHora());
    assertEquals(RelogioAmericano.Periodo.PM, destino.getPeriodo());
  }

  @Test
  void deveSincronizarOnzeHorasDaNoiteDoRelogioBrasileiro() {
    RelogioBrasileiro origem = new RelogioBrasileiro();
    origem.setHora(23);
    RelogioAmericano destino = new RelogioAmericano();

    destino.sincronizar(origem);

    assertEquals(11, destino.getHora());
    assertEquals(RelogioAmericano.Periodo.PM, destino.getPeriodo());
  }
}
