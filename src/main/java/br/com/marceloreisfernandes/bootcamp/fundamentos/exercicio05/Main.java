package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio05;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Informe um número:");
    int numero = scanner.nextInt();

    for (String linha : GeradorTabuada.gerar(numero)) {
      System.out.println(linha);
    }

    scanner.close();
  }
}