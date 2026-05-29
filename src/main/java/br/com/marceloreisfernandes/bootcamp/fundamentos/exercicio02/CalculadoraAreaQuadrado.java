package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio02;

public class CalculadoraAreaQuadrado {

  public static double calcular(double lado) {
    if (lado <= 0) {
      throw new IllegalArgumentException("O lado do quadrado deve ser maior que zero.");
    }

    return lado * lado;
  }
}