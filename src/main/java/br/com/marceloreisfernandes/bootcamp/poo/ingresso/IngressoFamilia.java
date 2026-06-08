package br.com.marceloreisfernandes.bootcamp.poo.ingresso;

public class IngressoFamilia extends Ingresso {

  private static final int QUANTIDADE_MINIMA_PESSOAS_DESCONTO = 3;
  private static final double PERCENTUAL_DESCONTO = 0.05;

  private final int numeroPessoas;

  public IngressoFamilia(double valor, String nomeFilme, boolean dublado, int numeroPessoas) {
    super(valor, nomeFilme, dublado);
    validarNumeroPessoas(numeroPessoas);

    this.numeroPessoas = numeroPessoas;
  }

  @Override
  public double getValorReal() {
    double valorTotal = getValor() * numeroPessoas;

    if (numeroPessoas > QUANTIDADE_MINIMA_PESSOAS_DESCONTO) {
      return valorTotal - valorTotal * PERCENTUAL_DESCONTO;
    }

    return valorTotal;
  }

  public int getNumeroPessoas() {
    return numeroPessoas;
  }

  private void validarNumeroPessoas(int numeroPessoas) {
    if (numeroPessoas <= 0) {
      throw new IllegalArgumentException("O número de pessoas deve ser maior que zero.");
    }
  }
}
