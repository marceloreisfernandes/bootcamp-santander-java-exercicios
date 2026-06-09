package br.com.marceloreisfernandes.bootcamp.poo.marketing;

public class Sms implements ServicoMensagem {

  @Override
  public String enviar(String mensagem) {
    return "SMS enviado: " + ValidadorMensagem.validar(mensagem);
  }
}
