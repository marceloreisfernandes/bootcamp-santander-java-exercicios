package br.com.marceloreisfernandes.bootcamp.poo.marketing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RedeSocialTest {

  @Test
  void deveEnviarMensagemPorRedeSocial() {
    var redeSocial = new RedeSocial();

    var retorno = redeSocial.enviar("Oferta exclusiva");

    assertEquals("Publicação enviada para rede social: Oferta exclusiva", retorno);
  }

  @Test
  void deveRejeitarMensagemNulaOuVazia() {
    var redeSocial = new RedeSocial();

    assertThrows(IllegalArgumentException.class, () -> redeSocial.enviar(null));
    assertThrows(IllegalArgumentException.class, () -> redeSocial.enviar(""));
    assertThrows(IllegalArgumentException.class, () -> redeSocial.enviar(" "));
  }
}
