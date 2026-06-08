package br.com.marceloreisfernandes.bootcamp.poo.relogio;

public class RelogioBrasileiro extends Relogio {

  @Override
  public void sincronizar(Relogio relogio) {
    if (relogio instanceof RelogioAmericano relogioAmericano) {
      setHora(converterHoraAmericanaParaBrasileira(relogioAmericano));
    } else {
      setHora(relogio.getHora());
    }

    setMinuto(relogio.getMinuto());
    setSegundo(relogio.getSegundo());
  }

  @Override
  protected void validarHora(int hora) {
    if (hora < 0 || hora > 23) {
      throw new IllegalArgumentException("A hora do relógio brasileiro deve estar entre 0 e 23.");
    }
  }

  private int converterHoraAmericanaParaBrasileira(RelogioAmericano relogioAmericano) {
    int hora = relogioAmericano.getHora();

    if (relogioAmericano.getPeriodo() == RelogioAmericano.Periodo.AM) {
      return hora == 12 ? 0 : hora;
    }

    return hora == 12 ? 12 : hora + 12;
  }
}
