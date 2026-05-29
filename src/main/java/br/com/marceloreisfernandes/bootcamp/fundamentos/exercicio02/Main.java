package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio02;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    var scanner = new Scanner(System.in);

    try {
      System.out.println("Informe o lado do quadrado:");
      var lado = Double.parseDouble(scanner.nextLine().replace(",", "."));

      var area = CalculadoraAreaQuadrado.calcular(lado);

      System.out.printf("A área do quadrado é %.2f.%n", area);
    } catch (NumberFormatException e) {
      System.out.println("Informe um número válido.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    scanner.close();
  }
}