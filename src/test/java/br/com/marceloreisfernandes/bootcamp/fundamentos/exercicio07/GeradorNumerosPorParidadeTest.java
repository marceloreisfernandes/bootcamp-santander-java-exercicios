package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio07;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GeradorNumerosPorParidadeTest {

  @Test
  void deveGerarParesEmOrdemDecrescente() {
    List<Integer> resultado = GeradorNumerosPorParidade.gerar(1, 10, "par");

    assertEquals(List.of(10, 8, 6, 4, 2), resultado);
  }

  @Test
  void deveGerarImparesEmOrdemDecrescente() {
    List<Integer> resultado = GeradorNumerosPorParidade.gerar(1, 10, "impar");

    assertEquals(List.of(9, 7, 5, 3, 1), resultado);
  }

  @Test
  void deveIncluirOsLimitesQuandoCombinaremComOTipo() {
    List<Integer> pares = GeradorNumerosPorParidade.gerar(2, 10, "par");
    List<Integer> impares = GeradorNumerosPorParidade.gerar(1, 9, "impar");

    assertEquals(List.of(10, 8, 6, 4, 2), pares);
    assertEquals(List.of(9, 7, 5, 3, 1), impares);
  }

  @Test
  void deveRejeitarSegundoNumeroMenorQueOPrimeiro() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> GeradorNumerosPorParidade.gerar(10, 5, "par"));

    assertEquals("O segundo número deve ser maior que o primeiro.", exception.getMessage());
  }

  @Test
  void deveRejeitarSegundoNumeroIgualAoPrimeiro() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> GeradorNumerosPorParidade.gerar(10, 10, "par"));

    assertEquals("O segundo número deve ser maior que o primeiro.", exception.getMessage());
  }

  @Test
  void deveRejeitarTipoInvalido() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> GeradorNumerosPorParidade.gerar(1, 10, "todos"));

    assertEquals("O tipo deve ser par ou impar.", exception.getMessage());
  }
}
