package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio03;

public class CalculadoraAreaRetangulo {

  public static double calcular(double base, double altura) {
    if (base <= 0) {
      throw new IllegalArgumentException("A base do retângulo deve ser maior que zero.");
    }

    if (altura <= 0) {
      throw new IllegalArgumentException("A altura do retângulo deve ser maior que zero.");
    }

    return base * altura;
  }
}