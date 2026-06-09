package br.com.marceloreisfernandes.bootcamp.poo.geometria;

public record Quadrado(double lado) implements FiguraGeometrica {

  public Quadrado {
    ValidadorMedida.validar(lado, "lado");
  }

  @Override
  public double calcularArea() {
    return lado * lado;
  }
}
