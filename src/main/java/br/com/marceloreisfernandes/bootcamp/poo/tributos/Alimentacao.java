package br.com.marceloreisfernandes.bootcamp.poo.tributos;

public record Alimentacao(double valor) implements ProdutoTributavel {

  private static final double PERCENTUAL_IMPOSTO = 0.01;

  public Alimentacao {
    ValidadorValorProduto.validar(valor);
  }

  @Override
  public double calcularImposto() {
    return valor * PERCENTUAL_IMPOSTO;
  }
}
