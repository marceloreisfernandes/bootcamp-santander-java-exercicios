package br.com.marceloreisfernandes.bootcamp.poo.geometria;

public record Retangulo(double base, double altura) implements FiguraGeometrica {

  public Retangulo {
    ValidadorMedida.validar(base, "base");
    ValidadorMedida.validar(altura, "altura");
  }

  @Override
  public double calcularArea() {
    return base * altura;
  }
}
