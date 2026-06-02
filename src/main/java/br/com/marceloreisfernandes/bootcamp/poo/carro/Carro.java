package br.com.marceloreisfernandes.bootcamp.poo.carro;

public class Carro {

  private static final int VELOCIDADE_MINIMA = 0;
  private static final int VELOCIDADE_MAXIMA = 120;
  private static final int MARCHA_MINIMA = 0;
  private static final int MARCHA_MAXIMA = 6;

  private boolean ligado;
  private int marcha;
  private int velocidade;

  public void ligar() {
    ligado = true;
  }

  public void desligar() {
    validarLigado();

    if (marcha != 0 || velocidade != 0) {
      throw new IllegalStateException("O carro só pode desligar em ponto morto e parado.");
    }

    ligado = false;
  }

  public void acelerar() {
    validarLigado();

    if (marcha == 0) {
      throw new IllegalStateException("Não é possível acelerar em ponto morto.");
    }

    if (velocidade == VELOCIDADE_MAXIMA) {
      throw new IllegalStateException("O carro já está na velocidade máxima.");
    }

    int novaVelocidade = velocidade + 1;

    if (!velocidadePermitidaParaAcelerar(novaVelocidade)) {
      throw new IllegalStateException("A velocidade não é permitida para a marcha atual.");
    }

    velocidade = novaVelocidade;
  }

  public void diminuirVelocidade() {
    validarLigado();

    if (velocidade == VELOCIDADE_MINIMA) {
      throw new IllegalStateException("O carro já está parado.");
    }

    int novaVelocidade = velocidade - 1;

    if (!velocidadePermitidaParaDiminuir(novaVelocidade)) {
      throw new IllegalStateException("A velocidade não é permitida para a marcha atual.");
    }

    velocidade = novaVelocidade;
  }

  public void virarEsquerda() {
    validarPodeVirar();
  }

  public void virarDireita() {
    validarPodeVirar();
  }

  public int consultarVelocidade() {
    return velocidade;
  }

  public int consultarMarcha() {
    return marcha;
  }

  public void trocarMarcha(int novaMarcha) {
    validarLigado();
    validarMarcha(novaMarcha);

    if (Math.abs(novaMarcha - marcha) != 1) {
      throw new IllegalStateException("Não é possível pular marcha.");
    }

    if (!podeTrocarParaMarcha(novaMarcha)) {
      throw new IllegalStateException("A velocidade atual não permite trocar para essa marcha.");
    }

    marcha = novaMarcha;
  }

  public boolean estaLigado() {
    return ligado;
  }

  private void validarLigado() {
    if (!ligado) {
      throw new IllegalStateException("O carro está desligado.");
    }
  }

  private void validarPodeVirar() {
    validarLigado();

    if (velocidade < 1 || velocidade > 40) {
      throw new IllegalStateException("O carro só pode virar entre 1 km/h e 40 km/h.");
    }
  }

  private void validarMarcha(int marcha) {
    if (marcha < MARCHA_MINIMA || marcha > MARCHA_MAXIMA) {
      throw new IllegalArgumentException("A marcha deve estar entre 0 e 6.");
    }
  }

  private boolean podeTrocarParaMarcha(int novaMarcha) {
    if (novaMarcha == 0) {
      return velocidade == 0;
    }

    if (velocidadePermitidaNaMarcha(velocidade, novaMarcha)) {
      return true;
    }

    if (novaMarcha == marcha + 1) {
      return velocidade == velocidadeMaximaDaMarcha(marcha);
    }

    if (novaMarcha == marcha - 1) {
      return velocidade == velocidadeMinimaDaMarcha(marcha);
    }

    return false;
  }

  private boolean velocidadePermitidaParaAcelerar(int velocidade) {
    return velocidadePermitidaNaMarcha(velocidade, marcha);
  }

  private boolean velocidadePermitidaParaDiminuir(int velocidade) {
    return velocidadePermitidaNaMarcha(velocidade, marcha);
  }

  private boolean velocidadePermitidaNaMarcha(int velocidade, int marcha) {
    return velocidade >= velocidadeMinimaDaMarcha(marcha)
        && velocidade <= velocidadeMaximaDaMarcha(marcha);
  }

  private int velocidadeMinimaDaMarcha(int marcha) {
    return switch (marcha) {
      case 1 -> 0;
      case 2 -> 21;
      case 3 -> 41;
      case 4 -> 61;
      case 5 -> 81;
      case 6 -> 101;
      default -> 0;
    };
  }

  private int velocidadeMaximaDaMarcha(int marcha) {
    return switch (marcha) {
      case 1 -> 20;
      case 2 -> 40;
      case 3 -> 60;
      case 4 -> 80;
      case 5 -> 100;
      case 6 -> 120;
      default -> 0;
    };
  }
}
