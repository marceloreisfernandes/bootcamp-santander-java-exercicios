package br.com.marceloreisfernandes.bootcamp.poo.relogio;

public abstract class Relogio {

  private int hora;
  private int minuto;
  private int segundo;

  public int getHora() {
    return hora;
  }

  public void setHora(int hora) {
    validarHora(hora);
    this.hora = hora;
  }

  public int getMinuto() {
    return minuto;
  }

  public void setMinuto(int minuto) {
    if (minuto < 0 || minuto > 59) {
      throw new IllegalArgumentException("O minuto deve estar entre 0 e 59.");
    }

    this.minuto = minuto;
  }

  public int getSegundo() {
    return segundo;
  }

  public void setSegundo(int segundo) {
    if (segundo < 0 || segundo > 59) {
      throw new IllegalArgumentException("O segundo deve estar entre 0 e 59.");
    }

    this.segundo = segundo;
  }

  public String getHoraFormatada() {
    return String.format("%02d:%02d:%02d", hora, minuto, segundo);
  }

  public abstract void sincronizar(Relogio relogio);

  protected abstract void validarHora(int hora);
}
