package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio07;

import java.util.ArrayList;
import java.util.List;

public class GeradorNumerosPorParidade {

  public static List<Integer> gerar(int primeiroNumero, int segundoNumero, String tipo) {
    if (segundoNumero <= primeiroNumero) {
      throw new IllegalArgumentException("O segundo número deve ser maior que o primeiro.");
    }

    if (!"par".equalsIgnoreCase(tipo) && !"impar".equalsIgnoreCase(tipo)) {
      throw new IllegalArgumentException("O tipo deve ser par ou impar.");
    }

    List<Integer> numeros = new ArrayList<>();
    boolean deveGerarPares = "par".equalsIgnoreCase(tipo);

    for (int numero = segundoNumero; numero >= primeiroNumero; numero--) {
      boolean numeroPar = numero % 2 == 0;

      if (numeroPar == deveGerarPares) {
        numeros.add(numero);
      }
    }

    return numeros;
  }
}
