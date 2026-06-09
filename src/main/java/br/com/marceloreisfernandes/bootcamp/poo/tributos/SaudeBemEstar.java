package br.com.marceloreisfernandes.bootcamp.poo.tributos;

public record SaudeBemEstar(double valor) implements ProdutoTributavel {

  private static final double PERCENTUAL_IMPOSTO = 0.015;

  public SaudeBemEstar {
    ValidadorValorProduto.validar(valor);
  }

  @Override
  public double calcularImposto() {
    return valor * PERCENTUAL_IMPOSTO;
  }
}
