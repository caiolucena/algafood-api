package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.algaworks.algafood.di.modelo.Cliente;

@Qualifier("urgente")
@Component
public class NotificadorEmail implements Notificador {

  private boolean caixaAlta;

  public NotificadorEmail() {
    System.out.println("Notificador Email");
  }

  @Override
  public void notificar(Cliente cliente, String mensagem) {

    if (this.caixaAlta) {
      mensagem = mensagem.toUpperCase();
    }

    System.out.printf("Notificando %s através do e-mail %s: %s\n", cliente.getNome(),
        cliente.getEmail(), mensagem);

  }

  public void setCaixaAlta(boolean caixaAlta) {
    this.caixaAlta = caixaAlta;
  }

}
