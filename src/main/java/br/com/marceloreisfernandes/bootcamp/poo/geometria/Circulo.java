package br.com.marceloreisfernandes.bootcamp.poo.geometria;

public record Circulo(double raio) implements FiguraGeometrica {

  public Circulo {
    ValidadorMedida.validar(raio, "raio");
  }

  @Override
  public double calcularArea() {
    return Math.PI * raio * raio;
  }
}
