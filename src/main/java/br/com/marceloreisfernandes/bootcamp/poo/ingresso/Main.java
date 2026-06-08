package br.com.marceloreisfernandes.bootcamp.poo.ingresso;

public class Main {

  public static void main(String[] args) {
    Ingresso ingresso = new Ingresso(40.0, "Matrix", true);
    Ingresso meiaEntrada = new MeiaEntrada(40.0, "Matrix", true);
    Ingresso ingressoFamilia = new IngressoFamilia(40.0, "Matrix", true, 4);

    imprimirIngresso(ingresso);
    imprimirIngresso(meiaEntrada);
    imprimirIngresso(ingressoFamilia);
  }

  private static void imprimirIngresso(Ingresso ingresso) {
    var tipoAudio = ingresso.isDublado() ? "dublado" : "legendado";

    System.out.printf("Filme: %s (%s) - Valor real: R$ %.2f%n",
        ingresso.getNomeFilme(), tipoAudio, ingresso.getValorReal());
  }
}
