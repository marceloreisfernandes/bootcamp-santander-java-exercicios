package br.com.marceloreisfernandes.bootcamp.poo.tributos;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    var produtos = List.of(
        new Alimentacao(100.0),
        new SaudeBemEstar(100.0),
        new Vestuario(100.0),
        new Cultura(100.0));

    produtos.forEach(Main::imprimirImposto);
  }

  private static void imprimirImposto(ProdutoTributavel produto) {
    System.out.printf("%s - Valor: R$ %.2f - Imposto: R$ %.2f%n",
        produto.getClass().getSimpleName(), produto.valor(), produto.calcularImposto());
  }
}
