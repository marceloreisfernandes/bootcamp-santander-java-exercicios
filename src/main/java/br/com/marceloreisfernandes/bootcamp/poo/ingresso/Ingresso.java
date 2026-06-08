package br.com.marceloreisfernandes.bootcamp.poo.ingresso;

public class Ingresso {

  private final double valor;
  private final String nomeFilme;
  private final boolean dublado;

  public Ingresso(double valor, String nomeFilme, boolean dublado) {
    validarValor(valor);
    validarNomeFilme(nomeFilme);

    this.valor = valor;
    this.nomeFilme = nomeFilme.trim();
    this.dublado = dublado;
  }

  public double getValorReal() {
    return valor;
  }

  public double getValor() {
    return valor;
  }

  public String getNomeFilme() {
    return nomeFilme;
  }

  public boolean isDublado() {
    return dublado;
  }

  private void validarValor(double valor) {
    if (valor <= 0) {
      throw new IllegalArgumentException("O valor do ingresso deve ser maior que zero.");
    }
  }

  private void validarNomeFilme(String nomeFilme) {
    if (nomeFilme == null || nomeFilme.isBlank()) {
      throw new IllegalArgumentException("O nome do filme não pode ser vazio.");
    }
  }
}
