package br.com.marceloreisfernandes.bootcamp.poo.relogio;

public class RelogioAmericano extends Relogio {

  public enum Periodo {
    AM,
    PM
  }

  private Periodo periodo = Periodo.AM;

  public RelogioAmericano() {
    setHora(12);
  }

  @Override
  public String getHoraFormatada() {
    return String.format("%s %s", super.getHoraFormatada(), periodo);
  }

  @Override
  public void sincronizar(Relogio relogio) {
    if (relogio instanceof RelogioAmericano relogioAmericano) {
      setHora(relogioAmericano.getHora());
      setPeriodo(relogioAmericano.getPeriodo());
    } else {
      aplicarHoraBrasileira(relogio.getHora());
    }

    setMinuto(relogio.getMinuto());
    setSegundo(relogio.getSegundo());
  }

  public Periodo getPeriodo() {
    return periodo;
  }

  public void setPeriodo(Periodo periodo) {
    if (periodo == null) {
      throw new IllegalArgumentException("O período não pode ser nulo.");
    }

    this.periodo = periodo;
  }

  @Override
  protected void validarHora(int hora) {
    if (hora < 1 || hora > 12) {
      throw new IllegalArgumentException("A hora do relógio americano deve estar entre 1 e 12.");
    }
  }

  private void aplicarHoraBrasileira(int hora) {
    if (hora == 0) {
      setHora(12);
      setPeriodo(Periodo.AM);
      return;
    }

    if (hora < 12) {
      setHora(hora);
      setPeriodo(Periodo.AM);
      return;
    }

    if (hora == 12) {
      setHora(12);
      setPeriodo(Periodo.PM);
      return;
    }

    setHora(hora - 12);
    setPeriodo(Periodo.PM);
  }
}
