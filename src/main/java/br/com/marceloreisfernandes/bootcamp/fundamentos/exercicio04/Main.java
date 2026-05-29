package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio04;

import br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio04.application.CalcularDiferencaIdadeUseCase;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    var scanner = new Scanner(System.in);

    try {
      System.out.println("Informe o nome da primeira pessoa:");
      var nomePrimeiraPessoa = scanner.nextLine();

      System.out.println("Informe a idade da primeira pessoa:");
      var idadePrimeiraPessoa = Integer.parseInt(scanner.nextLine());

      System.out.println("Informe o nome da segunda pessoa:");
      var nomeSegundaPessoa = scanner.nextLine();

      System.out.println("Informe a idade da segunda pessoa:");
      var idadeSegundaPessoa = Integer.parseInt(scanner.nextLine());

      var useCase = new CalcularDiferencaIdadeUseCase();
      var diferencaIdade = useCase.executar(nomePrimeiraPessoa, idadePrimeiraPessoa,
          nomeSegundaPessoa, idadeSegundaPessoa);

      System.out.printf("A diferença de idade entre %s e %s é de %d anos.%n",
          nomePrimeiraPessoa.trim(), nomeSegundaPessoa.trim(), diferencaIdade);
    } catch (NumberFormatException e) {
      System.out.println("Informe uma idade válida.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    scanner.close();
  }
}
