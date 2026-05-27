package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class DataNascimentoParser {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/uuuu")
            .withResolverStyle(ResolverStyle.STRICT);

    public static LocalDate parse(String dataNascimento) {
        return LocalDate.parse(dataNascimento, FORMATTER);
    }
}