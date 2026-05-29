package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio04.domain;

public record Pessoa(String nome, int idade) {

  public Pessoa {
    if (nome == null || nome.isBlank()) {
      throw new IllegalArgumentException("O nome da pessoa não pode ser vazio.");
    }

    if (idade < 0) {
      throw new IllegalArgumentException("A idade da pessoa não pode ser negativa.");
    }

    nome = nome.trim();
  }
}
