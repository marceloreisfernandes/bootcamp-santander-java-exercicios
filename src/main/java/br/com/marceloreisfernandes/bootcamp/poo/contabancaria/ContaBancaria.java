package br.com.marceloreisfernandes.bootcamp.poo.contabancaria;

public class ContaBancaria {

  private static final double VALOR_CHEQUE_ESPECIAL_PADRAO = 50.0;
  private static final double PERCENTUAL_CHEQUE_ESPECIAL = 0.5;
  private static final double TAXA_USO_CHEQUE_ESPECIAL = 0.2;

  private double saldo;
  private final double limiteChequeEspecial;
  private double valorUsadoChequeEspecial;

  public ContaBancaria(double saldoInicial) {
    validarValorNaoNegativo(saldoInicial, "O saldo inicial não pode ser negativo.");

    this.saldo = saldoInicial;
    this.limiteChequeEspecial = calcularLimiteChequeEspecial(saldoInicial);
  }

  public double consultarSaldo() {
    return saldo;
  }

  public double consultarChequeEspecial() {
    return limiteChequeEspecial - valorUsadoChequeEspecial;
  }

  public void depositar(double valor) {
    validarValorPositivo(valor, "O valor do depósito deve ser maior que zero.");

    double valorUsadoAntesDoDeposito = valorUsadoChequeEspecial;
    saldo += valor;
    cobrarTaxaChequeEspecialSeNecessario(valor, valorUsadoAntesDoDeposito);
    atualizarValorUsadoChequeEspecial();
  }

  public void sacar(double valor) {
    validarValorPositivo(valor, "O valor do saque deve ser maior que zero.");
    debitar(valor);
  }

  public void pagarBoleto(double valor) {
    validarValorPositivo(valor, "O valor do boleto deve ser maior que zero.");
    debitar(valor);
  }

  public boolean estaUsandoChequeEspecial() {
    return valorUsadoChequeEspecial > 0;
  }

  private double calcularLimiteChequeEspecial(double saldoInicial) {
    if (saldoInicial <= 500.0) {
      return VALOR_CHEQUE_ESPECIAL_PADRAO;
    }

    return saldoInicial * PERCENTUAL_CHEQUE_ESPECIAL;
  }

  private void debitar(double valor) {
    if (valor > saldo + consultarChequeEspecial()) {
      throw new IllegalArgumentException("Saldo insuficiente.");
    }

    saldo -= valor;

    if (saldo < 0) {
      atualizarValorUsadoChequeEspecial();
    }
  }

  private void cobrarTaxaChequeEspecialSeNecessario(double valorDepositado,
      double valorUsadoAntesDoDeposito) {
    if (valorUsadoAntesDoDeposito <= 0) {
      return;
    }

    double valorQuitadoChequeEspecial = Math.min(valorDepositado, valorUsadoAntesDoDeposito);
    double taxa = valorQuitadoChequeEspecial * TAXA_USO_CHEQUE_ESPECIAL;

    saldo -= taxa;
  }

  private void atualizarValorUsadoChequeEspecial() {
    valorUsadoChequeEspecial = Math.max(0, -saldo);
  }

  private void validarValorPositivo(double valor, String mensagem) {
    if (valor <= 0) {
      throw new IllegalArgumentException(mensagem);
    }
  }

  private void validarValorNaoNegativo(double valor, String mensagem) {
    if (valor < 0) {
      throw new IllegalArgumentException(mensagem);
    }
  }
}
