package br.com.marceloreisfernandes.bootcamp.poo.petshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MaquinaBanhoTest {

  @Test
  void deveIniciarSemPetSemAguaSemShampooELimpa() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();

    assertFalse(maquinaBanho.temPetNoBanho());
    assertEquals(0, maquinaBanho.verificarNivelAgua());
    assertEquals(0, maquinaBanho.verificarNivelShampoo());
    assertFalse(maquinaBanho.estaSuja());
  }

  @Test
  void deveAbastecerAguaDeDoisEmDoisLitros() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();

    maquinaBanho.abastecerAgua();
    maquinaBanho.abastecerAgua();

    assertEquals(4, maquinaBanho.verificarNivelAgua());
  }

  @Test
  void deveAbastecerShampooDeDoisEmDoisLitros() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();

    maquinaBanho.abastecerShampoo();
    maquinaBanho.abastecerShampoo();

    assertEquals(4, maquinaBanho.verificarNivelShampoo());
  }

  @Test
  void deveImpedirUltrapassarCapacidadeMaximaDeAgua() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();
    abastecerAgua(maquinaBanho, 30);

    assertThrows(IllegalStateException.class, maquinaBanho::abastecerAgua);
    assertEquals(30, maquinaBanho.verificarNivelAgua());
  }

  @Test
  void deveImpedirUltrapassarCapacidadeMaximaDeShampoo() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();
    abastecerShampoo(maquinaBanho, 10);

    assertThrows(IllegalStateException.class, maquinaBanho::abastecerShampoo);
    assertEquals(10, maquinaBanho.verificarNivelShampoo());
  }

  @Test
  void deveColocarPetNaMaquina() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();

    maquinaBanho.colocarPetNaMaquina();

    assertTrue(maquinaBanho.temPetNoBanho());
  }

  @Test
  void deveImpedirColocarMaisDeUmPet() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();

    maquinaBanho.colocarPetNaMaquina();

    assertThrows(IllegalStateException.class, maquinaBanho::colocarPetNaMaquina);
  }

  @Test
  void deveImpedirColocarPetComMaquinaSuja() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();
    maquinaBanho.colocarPetNaMaquina();
    maquinaBanho.retirarPetDaMaquina();

    assertThrows(IllegalStateException.class, maquinaBanho::colocarPetNaMaquina);
  }

  @Test
  void deveDarBanhoConsumindoDezLitrosDeAguaEDoisLitrosDeShampoo() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();
    abastecerAgua(maquinaBanho, 10);
    abastecerShampoo(maquinaBanho, 2);
    maquinaBanho.colocarPetNaMaquina();

    maquinaBanho.darBanhoNoPet();

    assertEquals(0, maquinaBanho.verificarNivelAgua());
    assertEquals(0, maquinaBanho.verificarNivelShampoo());
  }

  @Test
  void deveImpedirBanhoSemPet() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();
    abastecerAgua(maquinaBanho, 10);
    abastecerShampoo(maquinaBanho, 2);

    assertThrows(IllegalStateException.class, maquinaBanho::darBanhoNoPet);
  }

  @Test
  void deveImpedirBanhoSemAguaSuficiente() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();
    abastecerAgua(maquinaBanho, 8);
    abastecerShampoo(maquinaBanho, 2);
    maquinaBanho.colocarPetNaMaquina();

    assertThrows(IllegalStateException.class, maquinaBanho::darBanhoNoPet);
  }

  @Test
  void deveImpedirBanhoSemShampooSuficiente() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();
    abastecerAgua(maquinaBanho, 10);
    maquinaBanho.colocarPetNaMaquina();

    assertThrows(IllegalStateException.class, maquinaBanho::darBanhoNoPet);
  }

  @Test
  void deveRetirarPetLimpoSemSujarAMaquina() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();
    abastecerAgua(maquinaBanho, 10);
    abastecerShampoo(maquinaBanho, 2);
    maquinaBanho.colocarPetNaMaquina();
    maquinaBanho.darBanhoNoPet();

    maquinaBanho.retirarPetDaMaquina();

    assertFalse(maquinaBanho.temPetNoBanho());
    assertFalse(maquinaBanho.estaSuja());
  }

  @Test
  void deveRetirarPetSujoDeixandoAMaquinaSuja() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();
    maquinaBanho.colocarPetNaMaquina();

    maquinaBanho.retirarPetDaMaquina();

    assertFalse(maquinaBanho.temPetNoBanho());
    assertTrue(maquinaBanho.estaSuja());
  }

  @Test
  void deveLimparMaquinaConsumindoTresLitrosDeAguaEUmLitroDeShampoo() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();
    abastecerAgua(maquinaBanho, 4);
    abastecerShampoo(maquinaBanho, 2);
    maquinaBanho.colocarPetNaMaquina();
    maquinaBanho.retirarPetDaMaquina();

    maquinaBanho.limparMaquina();

    assertEquals(1, maquinaBanho.verificarNivelAgua());
    assertEquals(1, maquinaBanho.verificarNivelShampoo());
    assertFalse(maquinaBanho.estaSuja());
  }

  @Test
  void deveImpedirLimparMaquinaSemAguaSuficiente() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();
    abastecerAgua(maquinaBanho, 2);
    abastecerShampoo(maquinaBanho, 2);

    assertThrows(IllegalStateException.class, maquinaBanho::limparMaquina);
  }

  @Test
  void deveImpedirLimparMaquinaSemShampooSuficiente() {
    MaquinaBanho maquinaBanho = new MaquinaBanho();
    abastecerAgua(maquinaBanho, 4);

    assertThrows(IllegalStateException.class, maquinaBanho::limparMaquina);
  }

  private void abastecerAgua(MaquinaBanho maquinaBanho, int litros) {
    for (int i = 0; i < litros; i += 2) {
      maquinaBanho.abastecerAgua();
    }
  }

  private void abastecerShampoo(MaquinaBanho maquinaBanho, int litros) {
    for (int i = 0; i < litros; i += 2) {
      maquinaBanho.abastecerShampoo();
    }
  }
}
