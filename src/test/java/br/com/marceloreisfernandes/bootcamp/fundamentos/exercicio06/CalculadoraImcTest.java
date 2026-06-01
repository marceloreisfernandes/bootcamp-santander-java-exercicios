package br.com.marceloreisfernandes.bootcamp.fundamentos.exercicio06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraImcTest {

  @Test
  void deveCalcularImc() {
    double imc = CalculadoraImc.calcular(80.0, 1.80);

    assertEquals(24.69, imc, 0.01);
  }

  @Test
  void deveRejeitarPesoZero() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> CalculadoraImc.calcular(0, 1.80));

    assertEquals("O peso deve ser maior que zero.", exception.getMessage());
  }

  @Test
  void deveRejeitarPesoNegativo() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> CalculadoraImc.calcular(-80.0, 1.80));

    assertEquals("O peso deve ser maior que zero.", exception.getMessage());
  }

  @Test
  void deveRejeitarAlturaZero() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> CalculadoraImc.calcular(80.0, 0));

    assertEquals("A altura deve ser maior que zero.", exception.getMessage());
  }

  @Test
  void deveRejeitarAlturaNegativa() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> CalculadoraImc.calcular(80.0, -1.80));

    assertEquals("A altura deve ser maior que zero.", exception.getMessage());
  }
}
