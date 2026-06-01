package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeradorTabuadaTest {

  @Test
  void deveGerarTabuadaDeUmAteDez() {
    List<String> resultado = GeradorTabuada.gerar(5);

    assertEquals(10, resultado.size());
    assertEquals("5 x 1 = 5", resultado.get(0));
    assertEquals("5 x 10 = 50", resultado.get(9));
  }
}