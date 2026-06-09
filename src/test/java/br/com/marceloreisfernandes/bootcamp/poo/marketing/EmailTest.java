package br.com.marceloreisfernandes.bootcamp.poo.marketing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {

  @Test
  void deveEnviarMensagemPorEmail() {
    var email = new Email();

    var retorno = email.enviar("Oferta exclusiva");

    assertEquals("E-mail enviado: Oferta exclusiva", retorno);
  }

  @Test
  void deveRejeitarMensagemNulaOuVazia() {
    var email = new Email();

    assertThrows(IllegalArgumentException.class, () -> email.enviar(null));
    assertThrows(IllegalArgumentException.class, () -> email.enviar(""));
    assertThrows(IllegalArgumentException.class, () -> email.enviar(" "));
  }
}
