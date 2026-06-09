package br.com.marceloreisfernandes.bootcamp.poo.geometria;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    var figuras = List.of(
        new Quadrado(4.0),
        new Retangulo(4.0, 6.0),
        new Circulo(3.0));

    figuras.forEach(Main::imprimirArea);
  }

  private static void imprimirArea(FiguraGeometrica figura) {
    System.out.printf("%s - Área: %.2f%n",
        figura.getClass().getSimpleName(), figura.calcularArea());
  }
}
