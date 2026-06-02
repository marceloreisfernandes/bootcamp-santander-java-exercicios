package br.com.marceloreisfernandes.bootcamp.poo.contabancaria;

import java.util.Locale;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner scanner = new Scanner(System.in);

    System.out.println("Informe o saldo inicial:");
    double saldoInicial = scanner.nextDouble();
    ContaBancaria contaBancaria = new ContaBancaria(saldoInicial);

    int opcao;

    do {
      System.out.println("Menu:");
      System.out.println("1 - Consultar saldo");
      System.out.println("2 - Consultar cheque especial");
      System.out.println("3 - Depositar");
      System.out.println("4 - Sacar");
      System.out.println("5 - Pagar boleto");
      System.out.println("6 - Verificar uso do cheque especial");
      System.out.println("0 - Sair");
      System.out.println("Informe uma opção:");
      opcao = scanner.nextInt();

      try {
        switch (opcao) {
          case 1 -> System.out.printf("Saldo: R$ %.2f%n", contaBancaria.consultarSaldo());
          case 2 -> System.out.printf("Cheque especial disponível: R$ %.2f%n",
              contaBancaria.consultarChequeEspecial());
          case 3 -> {
            System.out.println("Informe o valor do depósito:");
            double valor = scanner.nextDouble();
            contaBancaria.depositar(valor);
            System.out.println("Depósito realizado.");
          }
          case 4 -> {
            System.out.println("Informe o valor do saque:");
            double valor = scanner.nextDouble();
            contaBancaria.sacar(valor);
            System.out.println("Saque realizado.");
          }
          case 5 -> {
            System.out.println("Informe o valor do boleto:");
            double valor = scanner.nextDouble();
            contaBancaria.pagarBoleto(valor);
            System.out.println("Boleto pago.");
          }
          case 6 -> {
            if (contaBancaria.estaUsandoChequeEspecial()) {
              System.out.println("A conta está usando cheque especial.");
            } else {
              System.out.println("A conta não está usando cheque especial.");
            }
          }
          case 0 -> System.out.println("Encerrando atendimento.");
          default -> System.out.println("Opção inválida.");
        }
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    } while (opcao != 0);

    scanner.close();
  }
}
