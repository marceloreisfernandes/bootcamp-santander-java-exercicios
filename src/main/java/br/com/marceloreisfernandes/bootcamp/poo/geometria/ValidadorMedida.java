package br.com.marceloreisfernandes.bootcamp.poo.geometria;

final class ValidadorMedida {

  private ValidadorMedida() {
  }

  static void validar(double medida, String nomeMedida) {
    if (medida <= 0) {
      throw new IllegalArgumentException("A medida " + nomeMedida + " deve ser maior que zero.");
    }
  }
}
