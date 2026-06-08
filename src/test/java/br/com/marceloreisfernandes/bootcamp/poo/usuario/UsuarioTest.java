package br.com.marceloreisfernandes.bootcamp.poo.usuario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UsuarioTest {

  @Test
  void deveCriarUsuarioComDadosValidos() {
    Usuario usuario = new Vendedor("João", "joao@empresa.com", "123456");

    assertEquals("João", usuario.getNome());
    assertEquals("joao@empresa.com", usuario.getEmail());
    assertFalse(usuario.isAdministrador());
    assertFalse(usuario.isLogado());
  }

  @Test
  void deveRemoverEspacosDoNomeEEmail() {
    Usuario usuario = new Vendedor(" João ", " joao@empresa.com ", "123456");

    assertEquals("João", usuario.getNome());
    assertEquals("joao@empresa.com", usuario.getEmail());
  }

  @Test
  void deveRealizarLoginComCredenciaisCorretas() {
    Usuario usuario = new Vendedor("João", "joao@empresa.com", "123456");

    boolean loginRealizado = usuario.realizarLogin("joao@empresa.com", "123456");

    assertTrue(loginRealizado);
    assertTrue(usuario.isLogado());
  }

  @Test
  void deveNaoRealizarLoginComCredenciaisIncorretas() {
    Usuario usuario = new Vendedor("João", "joao@empresa.com", "123456");

    boolean loginRealizado = usuario.realizarLogin("joao@empresa.com", "senha-errada");

    assertFalse(loginRealizado);
    assertFalse(usuario.isLogado());
  }

  @Test
  void deveRealizarLogoff() {
    Usuario usuario = new Vendedor("João", "joao@empresa.com", "123456");
    usuario.realizarLogin("joao@empresa.com", "123456");

    usuario.realizarLogoff();

    assertFalse(usuario.isLogado());
  }

  @Test
  void deveAlterarDados() {
    Usuario usuario = new Vendedor("João", "joao@empresa.com", "123456");

    usuario.alterarDados("Maria", "maria@empresa.com");

    assertEquals("Maria", usuario.getNome());
    assertEquals("maria@empresa.com", usuario.getEmail());
  }

  @Test
  void deveAlterarSenha() {
    Usuario usuario = new Vendedor("João", "joao@empresa.com", "123456");

    usuario.alterarSenha("123456", "nova-senha");

    assertTrue(usuario.realizarLogin("joao@empresa.com", "nova-senha"));
  }

  @Test
  void deveRejeitarSenhaAtualIncorretaAoAlterarSenha() {
    Usuario usuario = new Vendedor("João", "joao@empresa.com", "123456");

    var exception = assertThrows(IllegalStateException.class,
        () -> usuario.alterarSenha("senha-errada", "nova-senha"));

    assertEquals("Senha atual incorreta.", exception.getMessage());
  }

  @Test
  void deveRejeitarDadosInvalidosNaCriacao() {
    assertThrows(IllegalArgumentException.class, () -> new Vendedor(null, "joao@empresa.com",
        "123456"));
    assertThrows(IllegalArgumentException.class, () -> new Vendedor("", "joao@empresa.com",
        "123456"));
    assertThrows(IllegalArgumentException.class, () -> new Vendedor("João", null, "123456"));
    assertThrows(IllegalArgumentException.class, () -> new Vendedor("João", "", "123456"));
    assertThrows(IllegalArgumentException.class, () -> new Vendedor("João", "joao@empresa.com",
        null));
    assertThrows(IllegalArgumentException.class, () -> new Vendedor("João", "joao@empresa.com",
        ""));
  }

  @Test
  void deveRejeitarDadosInvalidosAoRealizarLogin() {
    Usuario usuario = new Vendedor("João", "joao@empresa.com", "123456");

    assertThrows(IllegalArgumentException.class, () -> usuario.realizarLogin(null, "123456"));
    assertThrows(IllegalArgumentException.class, () -> usuario.realizarLogin("", "123456"));
    assertThrows(IllegalArgumentException.class, () -> usuario.realizarLogin("joao@empresa.com",
        null));
    assertThrows(IllegalArgumentException.class, () -> usuario.realizarLogin("joao@empresa.com",
        ""));
  }

  @Test
  void deveRejeitarDadosInvalidosAoAlterarDados() {
    Usuario usuario = new Vendedor("João", "joao@empresa.com", "123456");

    assertThrows(IllegalArgumentException.class, () -> usuario.alterarDados(null,
        "maria@empresa.com"));
    assertThrows(IllegalArgumentException.class, () -> usuario.alterarDados("",
        "maria@empresa.com"));
    assertThrows(IllegalArgumentException.class, () -> usuario.alterarDados("Maria", null));
    assertThrows(IllegalArgumentException.class, () -> usuario.alterarDados("Maria", ""));
  }

  @Test
  void deveRejeitarSenhaAtualOuNovaSenhaVaziaAoAlterarSenha() {
    Usuario usuario = new Vendedor("João", "joao@empresa.com", "123456");

    assertThrows(IllegalArgumentException.class, () -> usuario.alterarSenha(null, "nova-senha"));
    assertThrows(IllegalArgumentException.class, () -> usuario.alterarSenha("", "nova-senha"));
    assertThrows(IllegalArgumentException.class, () -> usuario.alterarSenha("123456", null));
    assertThrows(IllegalArgumentException.class, () -> usuario.alterarSenha("123456", ""));
  }
}
