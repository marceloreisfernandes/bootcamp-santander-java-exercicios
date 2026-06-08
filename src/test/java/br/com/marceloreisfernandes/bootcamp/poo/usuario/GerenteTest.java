package br.com.marceloreisfernandes.bootcamp.poo.usuario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GerenteTest {

  @Test
  void deveSerUmUsuario() {
    Gerente gerente = new Gerente("Maria", "maria@empresa.com", "123456");

    assertInstanceOf(Usuario.class, gerente);
  }

  @Test
  void deveSerAdministrador() {
    Gerente gerente = new Gerente("Maria", "maria@empresa.com", "123456");

    assertTrue(gerente.isAdministrador());
  }

  @Test
  void deveGerarRelatorioFinanceiro() {
    Gerente gerente = new Gerente("Maria", "maria@empresa.com", "123456");

    assertEquals("Relatório financeiro gerado.", gerente.gerarRelatorioFinanceiro());
  }

  @Test
  void deveConsultarVendas() {
    Gerente gerente = new Gerente("Maria", "maria@empresa.com", "123456");

    assertEquals("Vendas consultadas.", gerente.consultarVendas());
  }
}
