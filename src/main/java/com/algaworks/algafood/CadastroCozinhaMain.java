package com.algaworks.algafood;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import com.algaworks.algafood.domain.model.Cozinha;

@Component
public class CadastroCozinhaMain {

  @PersistenceContext
  private EntityManager manager;

  public List<Cozinha> listar() {

    final TypedQuery<Cozinha> query = this.manager.createQuery("from Cozinha", Cozinha.class);

    return query.getResultList();

  }

  public Cozinha buscar(Long id) {

    return manager.find(Cozinha.class, id);
    
  }

  @Transactional
  public Cozinha adicionar(Cozinha cozinha) {

    return manager.merge(cozinha);

  }


}
