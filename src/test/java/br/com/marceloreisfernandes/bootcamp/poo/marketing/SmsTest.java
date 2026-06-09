package br.com.marceloreisfernandes.bootcamp.poo.marketing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SmsTest {

  @Test
  void deveEnviarMensagemPorSms() {
    var sms = new Sms();

    var retorno = sms.enviar("Oferta exclusiva");

    assertEquals("SMS enviado: Oferta exclusiva", retorno);
  }

  @Test
  void deveRemoverEspacosDaMensagem() {
    var sms = new Sms();

    var retorno = sms.enviar("  Oferta exclusiva  ");

    assertEquals("SMS enviado: Oferta exclusiva", retorno);
  }

  @Test
  void deveRejeitarMensagemNulaOuVazia() {
    var sms = new Sms();

    assertThrows(IllegalArgumentException.class, () -> sms.enviar(null));
    assertThrows(IllegalArgumentException.class, () -> sms.enviar(""));
    assertThrows(IllegalArgumentException.class, () -> sms.enviar(" "));
  }
}
