package br.com.marceloreisfernandes.bootcamp.poo.marketing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ServicoMensagemTest {

  @Test
  void deveRepresentarSmsComoServicoMensagem() {
    assertInstanceOf(ServicoMensagem.class, new Sms());
  }

  @Test
  void deveRepresentarEmailComoServicoMensagem() {
    assertInstanceOf(ServicoMensagem.class, new Email());
  }

  @Test
  void deveRepresentarRedeSocialComoServicoMensagem() {
    assertInstanceOf(ServicoMensagem.class, new RedeSocial());
  }

  @Test
  void deveRepresentarWhatsAppComoServicoMensagem() {
    assertInstanceOf(ServicoMensagem.class, new WhatsApp());
  }
}
