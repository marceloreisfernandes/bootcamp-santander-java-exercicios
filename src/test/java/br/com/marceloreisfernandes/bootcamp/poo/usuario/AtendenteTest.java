package br.com.marceloreisfernandes.bootcamp.poo.usuario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AtendenteTest {

  private static final double DELTA = 0.001;

  @Test
  void deveSerUmUsuario() {
    Atendente atendente = new Atendente("Ana", "ana@empresa.com", "123456");

    assertInstanceOf(Usuario.class, atendente);
  }

  @Test
  void deveNaoSerAdministrador() {
    Atendente atendente = new Atendente("Ana", "ana@empresa.com", "123456");

    assertFalse(atendente.isAdministrador());
  }

  @Test
  void deveIniciarComCaixaZerado() {
    Atendente atendente = new Atendente("Ana", "ana@empresa.com", "123456");

    assertEquals(0, atendente.getValorEmCaixa(), DELTA);
  }

  @Test
  void deveReceberPagamento() {
    Atendente atendente = new Atendente("Ana", "ana@empresa.com", "123456");

    atendente.receberPagamento(50.0);
    atendente.receberPagamento(30.0);

    assertEquals(80.0, atendente.getValorEmCaixa(), DELTA);
  }

  @Test
  void deveFecharCaixaRetornandoValorAtualEZerandoCaixa() {
    Atendente atendente = new Atendente("Ana", "ana@empresa.com", "123456");
    atendente.receberPagamento(80.0);

    double valorFechamento = atendente.fecharCaixa();

    assertEquals(80.0, valorFechamento, DELTA);
    assertEquals(0, atendente.getValorEmCaixa(), DELTA);
  }

  @Test
  void deveRejeitarPagamentoZeroOuNegativo() {
    Atendente atendente = new Atendente("Ana", "ana@empresa.com", "123456");

    assertThrows(IllegalArgumentException.class, () -> atendente.receberPagamento(0));
    assertThrows(IllegalArgumentException.class, () -> atendente.receberPagamento(-1));
  }
}
