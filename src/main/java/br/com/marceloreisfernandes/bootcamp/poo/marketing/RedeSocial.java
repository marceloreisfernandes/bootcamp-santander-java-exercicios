package br.com.marceloreisfernandes.bootcamp.poo.marketing;

public class RedeSocial implements ServicoMensagem {

  @Override
  public String enviar(String mensagem) {
    return "Publicação enviada para rede social: " + ValidadorMensagem.validar(mensagem);
  }
}
