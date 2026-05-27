package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio01;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraIdadeTest {

    @Test
    void deveCalcularIdadeQuandoAniversarioJaPassou() {
        var dataNascimento = LocalDate.of(1985, 5, 14);
        var dataAtual = LocalDate.of(2026, 5, 27);

        var idade = CalculadoraIdade.calcular(dataNascimento, dataAtual);

        assertEquals(41, idade);
    }

    @Test
    void deveCalcularIdadeQuandoAniversarioAindaNaoPassou() {
        var dataNascimento = LocalDate.of(1985, 12, 10);
        var dataAtual = LocalDate.of(2026, 5, 27);

        var idade = CalculadoraIdade.calcular(dataNascimento, dataAtual);

        assertEquals(40, idade);
    }

    @Test
    void deveRejeitarDataNascimentoNoFuturo() {
        var dataNascimento = LocalDate.of(2026, 5, 30);
        var dataAtual = LocalDate.of(2026, 5, 27);

        var exception = assertThrows(IllegalArgumentException.class,
                () -> CalculadoraIdade.calcular(dataNascimento, dataAtual));

        assertEquals("Data de nascimento não pode ser futura.", exception.getMessage());
    }
}
