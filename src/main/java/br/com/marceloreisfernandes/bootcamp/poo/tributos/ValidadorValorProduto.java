package br.com.marceloreisfernandes.bootcamp.poo.tributos;

final class ValidadorValorProduto {

  private ValidadorValorProduto() {
  }

  static void validar(double valor) {
    if (valor < 0) {
      throw new IllegalArgumentException("O valor do produto não pode ser negativo.");
    }
  }
}
