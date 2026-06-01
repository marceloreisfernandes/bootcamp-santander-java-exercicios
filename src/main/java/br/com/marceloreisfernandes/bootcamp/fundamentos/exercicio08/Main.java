package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio08;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Informe o número inicial:");
    int numeroInicial = scanner.nextInt();

    while (true) {
      System.out.println("Informe um número para verificação:");
      int numeroVerificacao = scanner.nextInt();

      if (VerificadorDivisibilidade.deveIgnorar(numeroInicial, numeroVerificacao)) {
        System.out.println("Número menor que o inicial. Informe outro número.");
        continue;
      }

      if (!VerificadorDivisibilidade.deveContinuar(numeroInicial, numeroVerificacao)) {
        break;
      }

      System.out.println("O número é divisível pelo número inicial.");
    }

    System.out.println("Execução encerrada.");
    scanner.close();
  }
}
