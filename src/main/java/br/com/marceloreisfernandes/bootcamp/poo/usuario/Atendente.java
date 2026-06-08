package br.com.marceloreisfernandes.bootcamp.poo.usuario;

public class Atendente extends Usuario {

  private double valorEmCaixa;

  public Atendente(String nome, String email, String senha) {
    super(nome, email, senha, false);
  }

  public void receberPagamento(double valor) {
    if (valor <= 0) {
      throw new IllegalArgumentException("O valor recebido deve ser maior que zero.");
    }

    valorEmCaixa += valor;
  }

  public double fecharCaixa() {
    double valorAtual = valorEmCaixa;
    valorEmCaixa = 0;

    return valorAtual;
  }

  public double getValorEmCaixa() {
    return valorEmCaixa;
  }
}
