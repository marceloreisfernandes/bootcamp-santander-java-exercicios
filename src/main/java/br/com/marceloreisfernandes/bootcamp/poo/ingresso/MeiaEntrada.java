package br.com.marceloreisfernandes.bootcamp.poo.ingresso;

public class MeiaEntrada extends Ingresso {

  private static final double PERCENTUAL_MEIA_ENTRADA = 0.5;

  public MeiaEntrada(double valor, String nomeFilme, boolean dublado) {
    super(valor, nomeFilme, dublado);
  }

  @Override
  public double getValorReal() {
    return getValor() * PERCENTUAL_MEIA_ENTRADA;
  }
}
