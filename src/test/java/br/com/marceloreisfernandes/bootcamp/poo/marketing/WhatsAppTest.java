package br.com.marceloreisfernandes.bootcamp.poo.marketing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WhatsAppTest {

  @Test
  void deveEnviarMensagemPorWhatsApp() {
    var whatsApp = new WhatsApp();

    var retorno = whatsApp.enviar("Oferta exclusiva");

    assertEquals("WhatsApp enviado: Oferta exclusiva", retorno);
  }

  @Test
  void deveRejeitarMensagemNulaOuVazia() {
    var whatsApp = new WhatsApp();

    assertThrows(IllegalArgumentException.class, () -> whatsApp.enviar(null));
    assertThrows(IllegalArgumentException.class, () -> whatsApp.enviar(""));
    assertThrows(IllegalArgumentException.class, () -> whatsApp.enviar(" "));
  }
}
