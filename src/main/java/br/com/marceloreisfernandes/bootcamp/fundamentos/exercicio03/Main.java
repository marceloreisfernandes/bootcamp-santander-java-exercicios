package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio03;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    var scanner = new Scanner(System.in);

    try {
      System.out.println("Informe a base do retângulo:");
      var base = Double.parseDouble(scanner.nextLine().replace(",", "."));

      System.out.println("Informe a altura do retângulo:");
      var altura = Double.parseDouble(scanner.nextLine().replace(",", "."));

      var area = CalculadoraAreaRetangulo.calcular(base, altura);

      System.out.printf("A área do retângulo é %.2f.%n", area);
    } catch (NumberFormatException e) {
      System.out.println("Informe um número válido.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    scanner.close();
  }
}