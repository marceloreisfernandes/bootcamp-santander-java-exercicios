package br.com.marceloreisfernandes.bootcamp.poo.relogio;

public class Main {

  public static void main(String[] args) {
    RelogioBrasileiro relogioBrasileiro = new RelogioBrasileiro();
    relogioBrasileiro.setHora(13);
    relogioBrasileiro.setMinuto(5);
    relogioBrasileiro.setSegundo(9);

    RelogioAmericano relogioAmericano = new RelogioAmericano();
    relogioAmericano.sincronizar(relogioBrasileiro);

    System.out.printf("Relógio brasileiro: %s%n", relogioBrasileiro.getHoraFormatada());
    System.out.printf("Relógio americano: %s%n", relogioAmericano.getHoraFormatada());
  }
}
