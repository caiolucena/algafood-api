package com.algaworks.algafood.infraestructure.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Restaurante> listar() {

    final TypedQuery<Restaurante> query =
        this.manager.createQuery("from Restaurante", Restaurante.class);

    return query.getResultList();

  }

  @Override
  public Restaurante buscar(Long id) {

    return this.manager.find(Restaurante.class, id);

  }


  @Override
  public Restaurante salvar(Restaurante restaurante) {

    return this.manager.merge(restaurante);

  }


  @Override
  public void remover(Restaurante restaurante) {
    restaurante = this.buscar(restaurante.getId());
    this.manager.remove(restaurante);

  }

}
