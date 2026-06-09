package br.com.marceloreisfernandes.bootcamp.poo.marketing;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    var mensagem = "Promoção especial do bootcamp Java";
    var servicos = List.of(new Sms(), new Email(), new RedeSocial(), new WhatsApp());

    servicos.forEach(servico -> System.out.println(servico.enviar(mensagem)));
  }
}
