package br.com.marceloreisfernandes.bootcamp.poo.petshop;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    MaquinaBanho maquinaBanho = new MaquinaBanho();
    int opcao;

    do {
      System.out.println("Menu:");
      System.out.println("1 - Dar banho no pet");
      System.out.println("2 - Abastecer com água");
      System.out.println("3 - Abastecer com shampoo");
      System.out.println("4 - Verificar nível de água");
      System.out.println("5 - Verificar nível de shampoo");
      System.out.println("6 - Verificar se tem pet no banho");
      System.out.println("7 - Colocar pet na máquina");
      System.out.println("8 - Retirar pet da máquina");
      System.out.println("9 - Limpar máquina");
      System.out.println("10 - Verificar se a máquina está suja");
      System.out.println("0 - Sair");
      System.out.println("Informe uma opção:");
      opcao = scanner.nextInt();

      try {
        switch (opcao) {
          case 1 -> {
            maquinaBanho.darBanhoNoPet();
            System.out.println("Banho realizado.");
          }
          case 2 -> {
            maquinaBanho.abastecerAgua();
            System.out.printf("Nível de água: %d litros.%n", maquinaBanho.verificarNivelAgua());
          }
          case 3 -> {
            maquinaBanho.abastecerShampoo();
            System.out.printf("Nível de shampoo: %d litros.%n",
                maquinaBanho.verificarNivelShampoo());
          }
          case 4 -> System.out.printf("Nível de água: %d litros.%n",
              maquinaBanho.verificarNivelAgua());
          case 5 -> System.out.printf("Nível de shampoo: %d litros.%n",
              maquinaBanho.verificarNivelShampoo());
          case 6 -> {
            if (maquinaBanho.temPetNoBanho()) {
              System.out.println("Há pet na máquina.");
            } else {
              System.out.println("Não há pet na máquina.");
            }
          }
          case 7 -> {
            maquinaBanho.colocarPetNaMaquina();
            System.out.println("Pet colocado na máquina.");
          }
          case 8 -> {
            maquinaBanho.retirarPetDaMaquina();
            System.out.println("Pet retirado da máquina.");
          }
          case 9 -> {
            maquinaBanho.limparMaquina();
            System.out.println("Máquina limpa.");
          }
          case 10 -> {
            if (maquinaBanho.estaSuja()) {
              System.out.println("A máquina está suja.");
            } else {
              System.out.println("A máquina está limpa.");
            }
          }
          case 0 -> System.out.println("Encerrando máquina de banho.");
          default -> System.out.println("Opção inválida.");
        }
      } catch (IllegalStateException e) {
        System.out.println(e.getMessage());
      }
    } while (opcao != 0);

    scanner.close();
  }
}
