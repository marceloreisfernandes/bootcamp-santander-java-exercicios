package br.com.marceloreisfernandes.bootcamp.poo.ingresso;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IngressoFamiliaTest {

  private static final double DELTA = 0.001;

  @Test
  void deveSerUmIngresso() {
    IngressoFamilia ingressoFamilia = new IngressoFamilia(40.0, "Matrix", true, 4);

    assertInstanceOf(Ingresso.class, ingressoFamilia);
  }

  @Test
  void deveRetornarValorMultiplicadoPeloNumeroDePessoas() {
    IngressoFamilia ingressoFamilia = new IngressoFamilia(40.0, "Matrix", true, 3);

    assertEquals(120.0, ingressoFamilia.getValorReal(), DELTA);
  }

  @Test
  void deveAplicarDescontoQuandoNumeroDePessoasForMaiorQueTres() {
    IngressoFamilia ingressoFamilia = new IngressoFamilia(40.0, "Matrix", true, 4);

    assertEquals(152.0, ingressoFamilia.getValorReal(), DELTA);
  }

  @Test
  void deveManterNumeroDePessoas() {
    IngressoFamilia ingressoFamilia = new IngressoFamilia(40.0, "Matrix", true, 4);

    assertEquals(4, ingressoFamilia.getNumeroPessoas());
  }

  @Test
  void deveRejeitarNumeroPessoasZeroOuNegativo() {
    assertThrows(IllegalArgumentException.class,
        () -> new IngressoFamilia(40.0, "Matrix", true, 0));
    assertThrows(IllegalArgumentException.class,
        () -> new IngressoFamilia(40.0, "Matrix", true, -1));
  }

  @Test
  void deveRejeitarDadosInvalidosDoIngresso() {
    assertThrows(IllegalArgumentException.class,
        () -> new IngressoFamilia(0, "Matrix", true, 4));
    assertThrows(IllegalArgumentException.class,
        () -> new IngressoFamilia(40.0, "", true, 4));
  }
}
