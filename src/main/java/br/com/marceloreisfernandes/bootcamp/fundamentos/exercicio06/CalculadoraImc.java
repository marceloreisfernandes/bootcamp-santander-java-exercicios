package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio06;

public class CalculadoraImc {

  public static double calcular(double peso, double altura) {
    if (peso <= 0) {
      throw new IllegalArgumentException("O peso deve ser maior que zero.");
    }

    if (altura <= 0) {
      throw new IllegalArgumentException("A altura deve ser maior que zero.");
    }

    return peso / (altura * altura);
  }
}
