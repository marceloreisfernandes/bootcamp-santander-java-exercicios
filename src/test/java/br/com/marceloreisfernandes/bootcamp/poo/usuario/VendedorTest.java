package br.com.marceloreisfernandes.bootcamp.poo.usuario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class VendedorTest {

  @Test
  void deveSerUmUsuario() {
    Vendedor vendedor = new Vendedor("João", "joao@empresa.com", "123456");

    assertInstanceOf(Usuario.class, vendedor);
  }

  @Test
  void deveNaoSerAdministrador() {
    Vendedor vendedor = new Vendedor("João", "joao@empresa.com", "123456");

    assertFalse(vendedor.isAdministrador());
  }

  @Test
  void deveIniciarComZeroVendas() {
    Vendedor vendedor = new Vendedor("João", "joao@empresa.com", "123456");

    assertEquals(0, vendedor.consultarVendas());
  }

  @Test
  void deveRealizarVenda() {
    Vendedor vendedor = new Vendedor("João", "joao@empresa.com", "123456");

    vendedor.realizarVenda();
    vendedor.realizarVenda();

    assertEquals(2, vendedor.consultarVendas());
  }
}
