package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio01;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class DataNascimentoParserTest {

    @Test
    void deveConverterDataValida() {
        var data = DataNascimentoParser.parse("14/05/1985");

        assertEquals(LocalDate.of(1985, 5, 14), data);
    }

    @Test
    void deveRejeitarMesInvalido() {
        assertThrows(DateTimeParseException.class,
                () -> DataNascimentoParser.parse("24/13/1985"));
    }
}
