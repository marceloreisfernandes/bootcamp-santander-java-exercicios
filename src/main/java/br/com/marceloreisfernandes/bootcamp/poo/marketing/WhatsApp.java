package br.com.marceloreisfernandes.bootcamp.poo.marketing;

public class WhatsApp implements ServicoMensagem {

  @Override
  public String enviar(String mensagem) {
    return "WhatsApp enviado: " + ValidadorMensagem.validar(mensagem);
  }
}
