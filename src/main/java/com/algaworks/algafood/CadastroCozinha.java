package com.algaworks.algafood;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import com.algaworks.algafood.domain.model.Cozinha;

@Component
public class CadastroCozinha {

  @PersistenceContext
  private EntityManager manager;

  public List<Cozinha> listar() {

    final TypedQuery<Cozinha> query = this.manager.createQuery("from Cozinha", Cozinha.class);

    return query.getResultList();

  }

  public Cozinha buscar(Long id) {

    return this.manager.find(Cozinha.class, id);

  }

  @Transactional
  public Cozinha adicionar(Cozinha cozinha) {

    return this.manager.merge(cozinha);

  }

  @Transactional
  public void remover(Cozinha cozinha) {
    cozinha = this.buscar(cozinha.getId());
    this.manager.remove(cozinha);

  }

}
