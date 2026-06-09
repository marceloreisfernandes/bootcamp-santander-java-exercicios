package br.com.marceloreisfernandes.bootcamp.poo.tributos;

public record Vestuario(double valor) implements ProdutoTributavel {

  private static final double PERCENTUAL_IMPOSTO = 0.025;

  public Vestuario {
    ValidadorValorProduto.validar(valor);
  }

  @Override
  public double calcularImposto() {
    return valor * PERCENTUAL_IMPOSTO;
  }
}
