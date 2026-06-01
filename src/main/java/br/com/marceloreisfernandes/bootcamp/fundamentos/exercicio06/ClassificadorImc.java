package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio06;

public class ClassificadorImc {

  public static String classificar(double imc) {
    if (imc <= 0) {
      throw new IllegalArgumentException("O IMC deve ser maior que zero.");
    }

    if (imc <= 18.5) {
      return "Abaixo do peso";
    }

    if (imc <= 24.9) {
      return "Peso ideal";
    }

    if (imc <= 29.9) {
      return "Levemente acima do peso";
    }

    if (imc <= 34.9) {
      return "Obesidade Grau I";
    }

    if (imc <= 39.9) {
      return "Obesidade Grau II";
    }

    return "Obesidade Grau III";
  }
}
