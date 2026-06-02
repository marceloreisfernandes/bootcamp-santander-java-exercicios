package br.com.marceloreisfernandes.bootcamp.poo.petshop;

public class MaquinaBanho {

  private static final int CAPACIDADE_MAXIMA_AGUA = 30;
  private static final int CAPACIDADE_MAXIMA_SHAMPOO = 10;
  private static final int QUANTIDADE_ABASTECIMENTO = 2;
  private static final int AGUA_POR_BANHO = 10;
  private static final int SHAMPOO_POR_BANHO = 2;
  private static final int AGUA_POR_LIMPEZA = 3;
  private static final int SHAMPOO_POR_LIMPEZA = 1;

  private boolean temPet;
  private boolean petLimpo;
  private int nivelAgua;
  private int nivelShampoo;
  private boolean suja;

  public void darBanhoNoPet() {
    if (!temPet) {
      throw new IllegalStateException("Não há pet na máquina.");
    }

    validarAguaSuficiente(AGUA_POR_BANHO);
    validarShampooSuficiente(SHAMPOO_POR_BANHO);

    nivelAgua -= AGUA_POR_BANHO;
    nivelShampoo -= SHAMPOO_POR_BANHO;
    petLimpo = true;
  }

  public void abastecerAgua() {
    if (nivelAgua + QUANTIDADE_ABASTECIMENTO > CAPACIDADE_MAXIMA_AGUA) {
      throw new IllegalStateException("A capacidade máxima de água é de 30 litros.");
    }

    nivelAgua += QUANTIDADE_ABASTECIMENTO;
  }

  public void abastecerShampoo() {
    if (nivelShampoo + QUANTIDADE_ABASTECIMENTO > CAPACIDADE_MAXIMA_SHAMPOO) {
      throw new IllegalStateException("A capacidade máxima de shampoo é de 10 litros.");
    }

    nivelShampoo += QUANTIDADE_ABASTECIMENTO;
  }

  public int verificarNivelAgua() {
    return nivelAgua;
  }

  public int verificarNivelShampoo() {
    return nivelShampoo;
  }

  public boolean temPetNoBanho() {
    return temPet;
  }

  public void colocarPetNaMaquina() {
    if (suja) {
      throw new IllegalStateException("A máquina está suja e precisa ser limpa.");
    }

    if (temPet) {
      throw new IllegalStateException("Já existe um pet na máquina.");
    }

    temPet = true;
    petLimpo = false;
  }

  public void retirarPetDaMaquina() {
    if (!temPet) {
      throw new IllegalStateException("Não há pet na máquina.");
    }

    if (!petLimpo) {
      suja = true;
    }

    temPet = false;
    petLimpo = false;
  }

  public void limparMaquina() {
    validarAguaSuficiente(AGUA_POR_LIMPEZA);
    validarShampooSuficiente(SHAMPOO_POR_LIMPEZA);

    nivelAgua -= AGUA_POR_LIMPEZA;
    nivelShampoo -= SHAMPOO_POR_LIMPEZA;
    suja = false;
  }

  public boolean estaSuja() {
    return suja;
  }

  private void validarAguaSuficiente(int quantidadeNecessaria) {
    if (nivelAgua < quantidadeNecessaria) {
      throw new IllegalStateException("Não há água suficiente.");
    }
  }

  private void validarShampooSuficiente(int quantidadeNecessaria) {
    if (nivelShampoo < quantidadeNecessaria) {
      throw new IllegalStateException("Não há shampoo suficiente.");
    }
  }
}
