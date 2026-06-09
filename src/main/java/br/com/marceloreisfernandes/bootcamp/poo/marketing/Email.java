package br.com.marceloreisfernandes.bootcamp.poo.marketing;

public class Email implements ServicoMensagem {

  @Override
  public String enviar(String mensagem) {
    return "E-mail enviado: " + ValidadorMensagem.validar(mensagem);
  }
}
