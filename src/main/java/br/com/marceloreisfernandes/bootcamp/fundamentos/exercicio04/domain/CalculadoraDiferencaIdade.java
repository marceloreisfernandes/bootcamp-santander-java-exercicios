package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio04.domain;

public class CalculadoraDiferencaIdade {

  public static int calcular(Pessoa primeiraPessoa, Pessoa segundaPessoa) {
    if (primeiraPessoa == null || segundaPessoa == null) {
      throw new IllegalArgumentException("As pessoas devem ser informadas.");
    }

    return Math.abs(primeiraPessoa.idade() - segundaPessoa.idade());
  }
}
