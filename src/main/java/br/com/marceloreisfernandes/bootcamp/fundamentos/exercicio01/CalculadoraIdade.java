package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio01;

import java.time.LocalDate;
import java.time.Period;

public class CalculadoraIdade {

    public static int calcular(LocalDate dataNascimento, LocalDate dataAtual) {
        if (dataNascimento.isAfter(dataAtual)) {
            throw new IllegalArgumentException("Data de nascimento não pode ser futura.");
        }

        return Period.between(dataNascimento, dataAtual).getYears();
    }
}
