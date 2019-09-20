package com.algaworks.algafood.di.notificacao;

import org.springframework.stereotype.Component;
import com.algaworks.algafood.di.modelo.Cliente;

@Component
public class NotificadorEmail implements Notificador {

  public NotificadorEmail() {
    System.out.println("Notificador Email");
  }

  /* (non-Javadoc)
   * @see com.algaworks.algafood.di.notificacao.Notificador#notificar(com.algaworks.algafood.di.modelo.Cliente, java.lang.String)
   */
  @Override
  public void notificar(Cliente cliente, String mensagem) {

    System.out.printf("Notificando %s através do e-mail %s: %s\n", cliente.getNome(),
        cliente.getEmail(), mensagem);

  }

}
