package br.com.marceloreisfernandes.bootcamp.poo.marketing;

final class ValidadorMensagem {

  private ValidadorMensagem() {
  }

  static String validar(String mensagem) {
    if (mensagem == null || mensagem.isBlank()) {
      throw new IllegalArgumentException("A mensagem não pode ser vazia.");
    }

    return mensagem.trim();
  }
}
