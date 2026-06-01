package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio05;

import java.util.ArrayList;
import java.util.List;

public class GeradorTabuada {

  public static List<String> gerar(int numero) {
    List<String> tabuada = new ArrayList<>();

    for (int i = 1; i <= 10; i++) {
      tabuada.add(numero + " x " + i + " = " + (numero * i));
    }

    return tabuada;
  }
}