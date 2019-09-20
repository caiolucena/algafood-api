package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.algaworks.algafood.NivelUrgencia;
import com.algaworks.algafood.TipoDoNotificador;
import com.algaworks.algafood.di.modelo.Cliente;

@Profile("prod")
@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorEmail implements Notificador {

  private boolean caixaAlta;

  @Value("${notificador.email.host-servidor}")
  private String host;

  @Value("${notificador.email.host-porta}")
  private String porta;

  public NotificadorEmail() {
    System.out.println("Notificador Email REAL");
  }

  @Override
  public void notificar(Cliente cliente, String mensagem) {

    if (this.caixaAlta) {
      mensagem = mensagem.toUpperCase();
    }

    System.out.println("Host: " + this.host);
    System.out.println("Port: " + this.porta);
    System.out.printf("Notificando %s através do e-mail %s: %s\n", cliente.getNome(),
        cliente.getEmail(), mensagem);

  }

  public void setCaixaAlta(boolean caixaAlta) {
    this.caixaAlta = caixaAlta;
  }

}
