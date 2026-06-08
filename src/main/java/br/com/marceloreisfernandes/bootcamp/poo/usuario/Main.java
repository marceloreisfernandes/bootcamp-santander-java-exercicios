package br.com.marceloreisfernandes.bootcamp.poo.usuario;

public class Main {

  public static void main(String[] args) {
    Gerente gerente = new Gerente("Maria", "maria@empresa.com", "123456");
    Vendedor vendedor = new Vendedor("João", "joao@empresa.com", "123456");
    Atendente atendente = new Atendente("Ana", "ana@empresa.com", "123456");

    gerente.realizarLogin("maria@empresa.com", "123456");
    vendedor.realizarVenda();
    atendente.receberPagamento(80.0);

    System.out.printf("%s - administrador: %s - logado: %s%n",
        gerente.getNome(), gerente.isAdministrador(), gerente.isLogado());
    System.out.printf("%s - vendas: %d%n", vendedor.getNome(), vendedor.consultarVendas());
    System.out.printf("%s - caixa fechado: R$ %.2f%n",
        atendente.getNome(), atendente.fecharCaixa());
  }
}
