package com.algaworks.algafood.di.notificacao;

import org.springframework.stereotype.Component;
import com.algaworks.algafood.NivelUrgencia;
import com.algaworks.algafood.TipoDoNotificador;
import com.algaworks.algafood.di.modelo.Cliente;

@TipoDoNotificador(NivelUrgencia.NORMAL)
@Component
public class NotificadorSMS implements Notificador {

  private boolean caixaAlta;

  public NotificadorSMS() {
    System.out.println("Notificador Email");
  }

  @Override
  public void notificar(Cliente cliente, String mensagem) {

    if (this.caixaAlta) {
      mensagem = mensagem.toUpperCase();
    }

    System.out.printf("Notificando %s através do celular %s: %s\n", cliente.getNome(),
        cliente.getTelefone(), mensagem);

  }

  public void setCaixaAlta(boolean caixaAlta) {
    this.caixaAlta = caixaAlta;
  }

}
