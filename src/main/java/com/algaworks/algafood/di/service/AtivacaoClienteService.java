package com.algaworks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.algaworks.algafood.NivelUrgencia;
import com.algaworks.algafood.TipoDoNotificador;
import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.Notificador;

// @Component
public class AtivacaoClienteService {

  @TipoDoNotificador(NivelUrgencia.URGENTE)
  @Autowired(required = false)
  private Notificador notificador;

  // @PostConstruct
  public void init() {
    System.out.println("INIT");
  }

  // @PreDestroy
  public void destroy() {
    System.out.println("DESTROY");
  }

  public void ativar(Cliente cliente) {
    cliente.ativar();

    notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");


  }

}
