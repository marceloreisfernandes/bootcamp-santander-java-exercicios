package br.com.marceloreisfernandes.bootcamp.poo.usuario;

public class Gerente extends Usuario {

  public Gerente(String nome, String email, String senha) {
    super(nome, email, senha, true);
  }

  public String gerarRelatorioFinanceiro() {
    return "Relatório financeiro gerado.";
  }

  public String consultarVendas() {
    return "Vendas consultadas.";
  }
}
