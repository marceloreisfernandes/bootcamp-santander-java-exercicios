package br.com.marceloreisfernandes.bootcamp.poo.contabancaria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContaBancariaTest {

  private static final double DELTA = 0.001;

  @Test
  void deveCriarContaComSaldoInicialELimitePadraoDeChequeEspecial() {
    ContaBancaria contaBancaria = new ContaBancaria(500.0);

    assertEquals(500.0, contaBancaria.consultarSaldo(), DELTA);
    assertEquals(50.0, contaBancaria.consultarChequeEspecial(), DELTA);
    assertFalse(contaBancaria.estaUsandoChequeEspecial());
  }

  @Test
  void deveCriarContaComMetadeDoSaldoInicialComoChequeEspecialQuandoSaldoForMaiorQueQuinhentos() {
    ContaBancaria contaBancaria = new ContaBancaria(1000.0);

    assertEquals(1000.0, contaBancaria.consultarSaldo(), DELTA);
    assertEquals(500.0, contaBancaria.consultarChequeEspecial(), DELTA);
  }

  @Test
  void deveDepositarValorNaConta() {
    ContaBancaria contaBancaria = new ContaBancaria(100.0);

    contaBancaria.depositar(50.0);

    assertEquals(150.0, contaBancaria.consultarSaldo(), DELTA);
  }

  @Test
  void deveSacarValorDaConta() {
    ContaBancaria contaBancaria = new ContaBancaria(100.0);

    contaBancaria.sacar(40.0);

    assertEquals(60.0, contaBancaria.consultarSaldo(), DELTA);
    assertFalse(contaBancaria.estaUsandoChequeEspecial());
  }

  @Test
  void devePagarBoleto() {
    ContaBancaria contaBancaria = new ContaBancaria(100.0);

    contaBancaria.pagarBoleto(80.0);

    assertEquals(20.0, contaBancaria.consultarSaldo(), DELTA);
  }

  @Test
  void deveUsarChequeEspecialQuandoSaldoNaoForSuficiente() {
    ContaBancaria contaBancaria = new ContaBancaria(100.0);

    contaBancaria.sacar(120.0);

    assertEquals(-20.0, contaBancaria.consultarSaldo(), DELTA);
    assertEquals(30.0, contaBancaria.consultarChequeEspecial(), DELTA);
    assertTrue(contaBancaria.estaUsandoChequeEspecial());
  }

  @Test
  void deveCobrarTaxaAoDepositarQuandoEstiverUsandoChequeEspecial() {
    ContaBancaria contaBancaria = new ContaBancaria(100.0);

    contaBancaria.sacar(120.0);
    contaBancaria.depositar(30.0);

    assertEquals(6.0, contaBancaria.consultarSaldo(), DELTA);
    assertEquals(50.0, contaBancaria.consultarChequeEspecial(), DELTA);
    assertFalse(contaBancaria.estaUsandoChequeEspecial());
  }

  @Test
  void deveCobrarTaxaEContinuarUsandoChequeEspecialQuandoDepositoForParcial() {
    ContaBancaria contaBancaria = new ContaBancaria(100.0);

    contaBancaria.sacar(120.0);
    contaBancaria.depositar(10.0);

    assertEquals(-12.0, contaBancaria.consultarSaldo(), DELTA);
    assertEquals(38.0, contaBancaria.consultarChequeEspecial(), DELTA);
    assertTrue(contaBancaria.estaUsandoChequeEspecial());
  }

  @Test
  void deveRejeitarSaqueMaiorQueSaldoMaisChequeEspecial() {
    ContaBancaria contaBancaria = new ContaBancaria(100.0);

    var exception = assertThrows(IllegalArgumentException.class,
        () -> contaBancaria.sacar(151.0));

    assertEquals("Saldo insuficiente.", exception.getMessage());
  }

  @Test
  void deveRejeitarSaldoInicialNegativo() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> new ContaBancaria(-1.0));

    assertEquals("O saldo inicial não pode ser negativo.", exception.getMessage());
  }

  @Test
  void deveRejeitarDepositoZeroOuNegativo() {
    ContaBancaria contaBancaria = new ContaBancaria(100.0);

    assertThrows(IllegalArgumentException.class, () -> contaBancaria.depositar(0));
    assertThrows(IllegalArgumentException.class, () -> contaBancaria.depositar(-1));
  }

  @Test
  void deveRejeitarSaqueZeroOuNegativo() {
    ContaBancaria contaBancaria = new ContaBancaria(100.0);

    assertThrows(IllegalArgumentException.class, () -> contaBancaria.sacar(0));
    assertThrows(IllegalArgumentException.class, () -> contaBancaria.sacar(-1));
  }

  @Test
  void deveRejeitarBoletoZeroOuNegativo() {
    ContaBancaria contaBancaria = new ContaBancaria(100.0);

    assertThrows(IllegalArgumentException.class, () -> contaBancaria.pagarBoleto(0));
    assertThrows(IllegalArgumentException.class, () -> contaBancaria.pagarBoleto(-1));
  }
}
