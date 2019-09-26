package com.algaworks.algafood.infraestructure.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Cozinha> listar() {

    final TypedQuery<Cozinha> query = this.manager.createQuery("from Cozinha", Cozinha.class);

    return query.getResultList();

  }

  @Override
  public Cozinha buscar(Long id) {

    return this.manager.find(Cozinha.class, id);

  }


  @Override
  public Cozinha salvar(Cozinha cozinha) {

    return this.manager.merge(cozinha);

  }


  @Override
  public void remover(Cozinha cozinha) {
    cozinha = this.buscar(cozinha.getId());
    this.manager.remove(cozinha);

  }

}