package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio01;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Informe o seu nome:");
        var nome = scanner.nextLine();

        System.out.println("Informe sua data de nascimento no formato dd/MM/yyyy:");
        var dataNascimentoTexto = scanner.nextLine();

        try {
            var dataNascimento = DataNascimentoParser.parse(dataNascimentoTexto);
            var idade = CalculadoraIdade.calcularDetalhada(dataNascimento, LocalDate.now());

            System.out.printf(
                    "Olá %s, você tem %d anos e %d dias.%n",
                    nome,
                    idade.anos(),
                    idade.dias());
        } catch (DateTimeParseException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}