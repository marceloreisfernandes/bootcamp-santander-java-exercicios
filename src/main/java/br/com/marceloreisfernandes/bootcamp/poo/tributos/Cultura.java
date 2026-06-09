package br.com.marceloreisfernandes.bootcamp.poo.tributos;

public record Cultura(double valor) implements ProdutoTributavel {

  private static final double PERCENTUAL_IMPOSTO = 0.04;

  public Cultura {
    ValidadorValorProduto.validar(valor);
  }

  @Override
  public double calcularImposto() {
    return valor * PERCENTUAL_IMPOSTO;
  }
}
