package com.algaworks.algafood.di.notificacao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.algaworks.algafood.NivelUrgencia;
import com.algaworks.algafood.TipoDoNotificador;
import com.algaworks.algafood.di.modelo.Cliente;

@Profile("dev")
@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorEmailMock implements Notificador {

  private boolean caixaAlta;

  public NotificadorEmailMock() {
    System.out.println("Notificador Email Mock");
  }

  @Override
  public void notificar(Cliente cliente, String mensagem) {

    if (this.caixaAlta) {
      mensagem = mensagem.toUpperCase();
    }

    System.out.printf("MOCK: Notificação seria enviada para %s através do e-mail %s: %s\n",
        cliente.getNome(), cliente.getEmail(), mensagem);

  }

  public void setCaixaAlta(boolean caixaAlta) {
    this.caixaAlta = caixaAlta;
  }

}
