package br.com.marceloreisfernandes.bootcamp.poo.carro;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Carro carro = new Carro();
    int opcao;

    do {
      System.out.println("Menu:");
      System.out.println("1 - Ligar carro");
      System.out.println("2 - Desligar carro");
      System.out.println("3 - Acelerar");
      System.out.println("4 - Diminuir velocidade");
      System.out.println("5 - Virar à esquerda");
      System.out.println("6 - Virar à direita");
      System.out.println("7 - Consultar velocidade");
      System.out.println("8 - Consultar marcha");
      System.out.println("9 - Trocar marcha");
      System.out.println("10 - Consultar se está ligado");
      System.out.println("0 - Sair");
      System.out.println("Informe uma opção:");
      opcao = scanner.nextInt();

      try {
        switch (opcao) {
          case 1 -> {
            carro.ligar();
            System.out.println("Carro ligado.");
          }
          case 2 -> {
            carro.desligar();
            System.out.println("Carro desligado.");
          }
          case 3 -> {
            carro.acelerar();
            System.out.printf("Velocidade atual: %d km/h.%n", carro.consultarVelocidade());
          }
          case 4 -> {
            carro.diminuirVelocidade();
            System.out.printf("Velocidade atual: %d km/h.%n", carro.consultarVelocidade());
          }
          case 5 -> {
            carro.virarEsquerda();
            System.out.println("Virou à esquerda.");
          }
          case 6 -> {
            carro.virarDireita();
            System.out.println("Virou à direita.");
          }
          case 7 -> System.out.printf("Velocidade atual: %d km/h.%n",
              carro.consultarVelocidade());
          case 8 -> System.out.printf("Marcha atual: %d.%n", carro.consultarMarcha());
          case 9 -> {
            System.out.println("Informe a nova marcha:");
            int marcha = scanner.nextInt();
            carro.trocarMarcha(marcha);
            System.out.printf("Marcha atual: %d.%n", carro.consultarMarcha());
          }
          case 10 -> {
            if (carro.estaLigado()) {
              System.out.println("O carro está ligado.");
            } else {
              System.out.println("O carro está desligado.");
            }
          }
          case 0 -> System.out.println("Encerrando controle do carro.");
          default -> System.out.println("Opção inválida.");
        }
      } catch (IllegalArgumentException | IllegalStateException e) {
        System.out.println(e.getMessage());
      }
    } while (opcao != 0);

    scanner.close();
  }
}
