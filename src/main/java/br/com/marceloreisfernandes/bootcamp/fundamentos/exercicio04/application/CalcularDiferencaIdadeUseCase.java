package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio04.application;

import br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio04.domain.CalculadoraDiferencaIdade;
import br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio04.domain.Pessoa;

public class CalcularDiferencaIdadeUseCase {

  public int executar(String nomePrimeiraPessoa, int idadePrimeiraPessoa,
      String nomeSegundaPessoa, int idadeSegundaPessoa) {
    var primeiraPessoa = new Pessoa(nomePrimeiraPessoa, idadePrimeiraPessoa);
    var segundaPessoa = new Pessoa(nomeSegundaPessoa, idadeSegundaPessoa);

    return CalculadoraDiferencaIdade.calcular(primeiraPessoa, segundaPessoa);
  }
}
