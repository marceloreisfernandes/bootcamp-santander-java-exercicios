package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio06;

import java.util.Locale;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner scanner = new Scanner(System.in);

    try {
      System.out.println("Informe o peso:");
      double peso = scanner.nextDouble();

      System.out.println("Informe a altura:");
      double altura = scanner.nextDouble();

      double imc = CalculadoraImc.calcular(peso, altura);
      String classificacao = ClassificadorImc.classificar(imc);

      System.out.printf("Seu IMC é %.2f. Classificação: %s.%n", imc, classificacao);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    scanner.close();
  }
}
