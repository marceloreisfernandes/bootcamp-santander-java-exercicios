package br.com.marceloreisfernandes.bootcamp.poo.usuario;

public class Vendedor extends Usuario {

  private int quantidadeVendas;

  public Vendedor(String nome, String email, String senha) {
    super(nome, email, senha, false);
  }

  public void realizarVenda() {
    quantidadeVendas++;
  }

  public int consultarVendas() {
    return quantidadeVendas;
  }
}
