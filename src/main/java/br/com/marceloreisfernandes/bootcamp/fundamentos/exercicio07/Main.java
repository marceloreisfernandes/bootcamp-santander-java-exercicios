package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio07;

import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Informe o primeiro número:");
    int primeiroNumero = scanner.nextInt();

    System.out.println("Informe o segundo número:");
    int segundoNumero = scanner.nextInt();

    while (segundoNumero <= primeiroNumero) {
      System.out.println("O segundo número deve ser maior que o primeiro. Informe novamente:");
      segundoNumero = scanner.nextInt();
    }

    System.out.println("Informe o tipo (par ou impar):");
    String tipo = scanner.next();

    while (!"par".equalsIgnoreCase(tipo) && !"impar".equalsIgnoreCase(tipo)) {
      System.out.println("Tipo inválido. Informe par ou impar:");
      tipo = scanner.next();
    }

    List<Integer> numeros = GeradorNumerosPorParidade.gerar(primeiroNumero, segundoNumero, tipo);

    for (Integer numero : numeros) {
      System.out.println(numero);
    }

    scanner.close();
  }
}
