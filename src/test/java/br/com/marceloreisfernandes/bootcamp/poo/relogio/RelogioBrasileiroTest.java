package br.com.marceloreisfernandes.bootcamp.poo.relogio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RelogioBrasileiroTest {

  @Test
  void deveSerUmRelogio() {
    RelogioBrasileiro relogioBrasileiro = new RelogioBrasileiro();

    assertInstanceOf(Relogio.class, relogioBrasileiro);
  }

  @Test
  void deveAceitarHoraEntreZeroEVinteETres() {
    RelogioBrasileiro relogioBrasileiro = new RelogioBrasileiro();

    relogioBrasileiro.setHora(0);
    assertEquals(0, relogioBrasileiro.getHora());

    relogioBrasileiro.setHora(23);
    assertEquals(23, relogioBrasileiro.getHora());
  }

  @Test
  void deveRejeitarHoraInvalida() {
    RelogioBrasileiro relogioBrasileiro = new RelogioBrasileiro();

    assertThrows(IllegalArgumentException.class, () -> relogioBrasileiro.setHora(-1));
    assertThrows(IllegalArgumentException.class, () -> relogioBrasileiro.setHora(24));
  }

  @Test
  void deveFormatarHoraNoFormatoVinteEQuatroHoras() {
    RelogioBrasileiro relogioBrasileiro = new RelogioBrasileiro();
    relogioBrasileiro.setHora(13);
    relogioBrasileiro.setMinuto(5);
    relogioBrasileiro.setSegundo(9);

    assertEquals("13:05:09", relogioBrasileiro.getHoraFormatada());
  }

  @Test
  void deveSincronizarComRelogioBrasileiro() {
    RelogioBrasileiro origem = new RelogioBrasileiro();
    origem.setHora(23);
    origem.setMinuto(58);
    origem.setSegundo(59);
    RelogioBrasileiro destino = new RelogioBrasileiro();

    destino.sincronizar(origem);

    assertEquals("23:58:59", destino.getHoraFormatada());
  }

  @Test
  void deveSincronizarUmaHoraDaTardeDoRelogioAmericano() {
    RelogioAmericano origem = new RelogioAmericano();
    origem.setHora(1);
    origem.setPeriodo(RelogioAmericano.Periodo.PM);
    RelogioBrasileiro destino = new RelogioBrasileiro();

    destino.sincronizar(origem);

    assertEquals(13, destino.getHora());
  }

  @Test
  void deveSincronizarMeioDiaDoRelogioAmericano() {
    RelogioAmericano origem = new RelogioAmericano();
    origem.setHora(12);
    origem.setPeriodo(RelogioAmericano.Periodo.PM);
    RelogioBrasileiro destino = new RelogioBrasileiro();

    destino.sincronizar(origem);

    assertEquals(12, destino.getHora());
  }

  @Test
  void deveSincronizarMeiaNoiteDoRelogioAmericano() {
    RelogioAmericano origem = new RelogioAmericano();
    origem.setHora(12);
    origem.setPeriodo(RelogioAmericano.Periodo.AM);
    RelogioBrasileiro destino = new RelogioBrasileiro();

    destino.sincronizar(origem);

    assertEquals(0, destino.getHora());
  }

  @Test
  void deveSincronizarDezDaManhaDoRelogioAmericano() {
    RelogioAmericano origem = new RelogioAmericano();
    origem.setHora(10);
    origem.setPeriodo(RelogioAmericano.Periodo.AM);
    RelogioBrasileiro destino = new RelogioBrasileiro();

    destino.sincronizar(origem);

    assertEquals(10, destino.getHora());
  }
}
