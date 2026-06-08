package br.com.marceloreisfernandes.bootcamp.poo.usuario;

public abstract class Usuario {

  private String nome;
  private String email;
  private String senha;
  private final boolean administrador;
  private boolean logado;

  protected Usuario(String nome, String email, String senha, boolean administrador) {
    validarTexto(nome, "O nome não pode ser vazio.");
    validarTexto(email, "O e-mail não pode ser vazio.");
    validarTexto(senha, "A senha não pode ser vazia.");

    this.nome = nome.trim();
    this.email = email.trim();
    this.senha = senha;
    this.administrador = administrador;
  }

  public boolean realizarLogin(String email, String senha) {
    validarTexto(email, "O e-mail não pode ser vazio.");
    validarTexto(senha, "A senha não pode ser vazia.");

    if (this.email.equals(email.trim()) && this.senha.equals(senha)) {
      logado = true;
      return true;
    }

    return false;
  }

  public void realizarLogoff() {
    logado = false;
  }

  public void alterarDados(String nome, String email) {
    validarTexto(nome, "O nome não pode ser vazio.");
    validarTexto(email, "O e-mail não pode ser vazio.");

    this.nome = nome.trim();
    this.email = email.trim();
  }

  public void alterarSenha(String senhaAtual, String novaSenha) {
    validarTexto(senhaAtual, "A senha atual não pode ser vazia.");
    validarTexto(novaSenha, "A nova senha não pode ser vazia.");

    if (!senha.equals(senhaAtual)) {
      throw new IllegalStateException("Senha atual incorreta.");
    }

    senha = novaSenha;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public boolean isAdministrador() {
    return administrador;
  }

  public boolean isLogado() {
    return logado;
  }

  private void validarTexto(String valor, String mensagem) {
    if (valor == null || valor.isBlank()) {
      throw new IllegalArgumentException(mensagem);
    }
  }
}
