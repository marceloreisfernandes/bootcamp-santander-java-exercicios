package br.com.marceloreisfernandes.bootcamp.poo.carro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarroTest {

  @Test
  void deveIniciarDesligadoEmPontoMortoEVelocidadeZero() {
    Carro carro = new Carro();

    assertFalse(carro.estaLigado());
    assertEquals(0, carro.consultarMarcha());
    assertEquals(0, carro.consultarVelocidade());
  }

  @Test
  void deveLigarCarro() {
    Carro carro = new Carro();

    carro.ligar();

    assertTrue(carro.estaLigado());
  }

  @Test
  void deveDesligarCarroCorretamente() {
    Carro carro = new Carro();
    carro.ligar();

    carro.desligar();

    assertFalse(carro.estaLigado());
    assertEquals(0, carro.consultarMarcha());
    assertEquals(0, carro.consultarVelocidade());
  }

  @Test
  void deveImpedirDesligarEmMovimento() {
    Carro carro = new Carro();
    carro.ligar();
    carro.trocarMarcha(1);
    carro.acelerar();

    assertThrows(IllegalStateException.class, carro::desligar);
  }

  @Test
  void deveImpedirDesligarForaDoPontoMorto() {
    Carro carro = new Carro();
    carro.ligar();
    carro.trocarMarcha(1);

    assertThrows(IllegalStateException.class, carro::desligar);
  }

  @Test
  void deveImpedirAcoesComCarroDesligado() {
    Carro carro = new Carro();

    assertThrows(IllegalStateException.class, carro::acelerar);
    assertThrows(IllegalStateException.class, carro::diminuirVelocidade);
    assertThrows(IllegalStateException.class, carro::virarEsquerda);
    assertThrows(IllegalStateException.class, carro::virarDireita);
    assertThrows(IllegalStateException.class, () -> carro.trocarMarcha(1));
  }

  @Test
  void deveAcelerar() {
    Carro carro = new Carro();
    carro.ligar();
    carro.trocarMarcha(1);

    carro.acelerar();

    assertEquals(1, carro.consultarVelocidade());
  }

  @Test
  void deveImpedirAcelerarEmPontoMorto() {
    Carro carro = new Carro();
    carro.ligar();

    assertThrows(IllegalStateException.class, carro::acelerar);
  }

  @Test
  void deveImpedirPassarDeCentoEVinteKmPorHora() {
    Carro carro = new Carro();
    prepararCarroNaVelocidade(carro, 120);

    assertThrows(IllegalStateException.class, carro::acelerar);
    assertEquals(120, carro.consultarVelocidade());
  }

  @Test
  void deveDiminuirVelocidade() {
    Carro carro = new Carro();
    prepararCarroNaVelocidade(carro, 2);

    carro.diminuirVelocidade();

    assertEquals(1, carro.consultarVelocidade());
  }

  @Test
  void deveImpedirVelocidadeMenorQueZero() {
    Carro carro = new Carro();
    carro.ligar();

    assertThrows(IllegalStateException.class, carro::diminuirVelocidade);
    assertEquals(0, carro.consultarVelocidade());
  }

  @Test
  void deveTrocarMarchaSemPular() {
    Carro carro = new Carro();
    carro.ligar();

    carro.trocarMarcha(1);

    assertEquals(1, carro.consultarMarcha());
  }

  @Test
  void deveImpedirPularMarcha() {
    Carro carro = new Carro();
    carro.ligar();

    assertThrows(IllegalStateException.class, () -> carro.trocarMarcha(2));
  }

  @Test
  void deveRejeitarMarchaInvalida() {
    Carro carro = new Carro();
    carro.ligar();

    assertThrows(IllegalArgumentException.class, () -> carro.trocarMarcha(-1));
    assertThrows(IllegalArgumentException.class, () -> carro.trocarMarcha(7));
  }

  @Test
  void deveRespeitarLimiteDeVelocidadeDaPrimeiraMarcha() {
    Carro carro = new Carro();
    prepararCarroNaVelocidade(carro, 20);

    assertThrows(IllegalStateException.class, carro::acelerar);
  }

  @Test
  void deveRespeitarLimiteDeVelocidadeDaSegundaMarcha() {
    Carro carro = new Carro();
    prepararCarroNaVelocidade(carro, 40);

    assertThrows(IllegalStateException.class, carro::acelerar);
  }

  @Test
  void devePermitirAcelerarNaSegundaMarchaAPartirDaTransicao() {
    Carro carro = new Carro();
    prepararCarroNaVelocidade(carro, 20);

    carro.trocarMarcha(2);
    carro.acelerar();

    assertEquals(2, carro.consultarMarcha());
    assertEquals(21, carro.consultarVelocidade());
  }

  @Test
  void deveImpedirTrocarMarchaForaDoLimiteDeVelocidade() {
    Carro carro = new Carro();
    prepararCarroNaVelocidade(carro, 10);

    assertThrows(IllegalStateException.class, () -> carro.trocarMarcha(2));
  }

  @Test
  void deveVirarEsquerdaEmVelocidadeValida() {
    Carro carro = new Carro();
    prepararCarroNaVelocidade(carro, 1);

    carro.virarEsquerda();

    assertEquals(1, carro.consultarVelocidade());
  }

  @Test
  void deveVirarDireitaEmVelocidadeValida() {
    Carro carro = new Carro();
    prepararCarroNaVelocidade(carro, 40);

    carro.virarDireita();

    assertEquals(40, carro.consultarVelocidade());
  }

  @Test
  void deveImpedirVirarParado() {
    Carro carro = new Carro();
    carro.ligar();

    assertThrows(IllegalStateException.class, carro::virarEsquerda);
    assertThrows(IllegalStateException.class, carro::virarDireita);
  }

  @Test
  void deveImpedirVirarAcimaDeQuarentaKmPorHora() {
    Carro carro = new Carro();
    prepararCarroNaVelocidade(carro, 41);

    assertThrows(IllegalStateException.class, carro::virarEsquerda);
    assertThrows(IllegalStateException.class, carro::virarDireita);
  }

  private void prepararCarroNaVelocidade(Carro carro, int velocidadeDesejada) {
    carro.ligar();
    carro.trocarMarcha(1);

    while (carro.consultarVelocidade() < velocidadeDesejada) {
      if (carro.consultarVelocidade() == velocidadeMaximaDaMarcha(carro.consultarMarcha())) {
        carro.trocarMarcha(carro.consultarMarcha() + 1);
      }

      carro.acelerar();
    }
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
