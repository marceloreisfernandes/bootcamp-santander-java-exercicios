package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VerificadorDivisibilidadeTest {

  @Test
  void deveIgnorarNumeroMenorQueOInicial() {
    boolean resultado = VerificadorDivisibilidade.deveIgnorar(10, 5);

    assertTrue(resultado);
  }

  @Test
  void deveContinuarQuandoORestoForZero() {
    boolean resultado = VerificadorDivisibilidade.deveContinuar(5, 20);

    assertTrue(resultado);
  }

  @Test
  void devePararQuandoORestoForDiferenteDeZero() {
    boolean resultado = VerificadorDivisibilidade.deveContinuar(5, 22);

    assertFalse(resultado);
  }

  @Test
  void deveRejeitarNumeroInicialZero() {
    assertThrows(IllegalArgumentException.class,
        () -> VerificadorDivisibilidade.deveContinuar(0, 10));
  }

  @Test
  void deveRejeitarNumeroInicialNegativo() {
    assertThrows(IllegalArgumentException.class,
        () -> VerificadorDivisibilidade.deveContinuar(-1, 10));
  }
}
