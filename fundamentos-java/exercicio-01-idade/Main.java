import java.time.OffsetDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Informe o seu nome:");
        var nome = scanner.next();

        System.out.println("Informe o seu ano de nascimento:");
        var anoNascimento = scanner.nextInt();

        var anoAtual = OffsetDateTime.now().getYear();
        var idade = anoAtual - anoNascimento;

        System.out.printf("Olá %s, você tem %s anos.%n", nome, idade);

        scanner.close();
    }
}
