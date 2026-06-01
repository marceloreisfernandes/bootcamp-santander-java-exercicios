package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio08;

public class VerificadorDivisibilidade {

  public static boolean deveIgnorar(int numeroInicial, int numeroVerificacao) {
    return numeroVerificacao < numeroInicial;
  }

  public static boolean deveContinuar(int numeroInicial, int numeroVerificacao) {
    if (numeroInicial <= 0) {
      throw new IllegalArgumentException("O número inicial deve ser maior que zero.");
    }

    return numeroVerificacao % numeroInicial == 0;
  }
}
