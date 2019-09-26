package com.algaworks.algafood.infraestructure.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<FormaPagamento> listar() {

    final TypedQuery<FormaPagamento> query =
        this.manager.createQuery("from FormaPagamento", FormaPagamento.class);

    return query.getResultList();

  }

  @Override
  public FormaPagamento buscar(Long id) {

    return this.manager.find(FormaPagamento.class, id);

  }


  @Override
  public FormaPagamento salvar(FormaPagamento formaPagamento) {

    return this.manager.merge(formaPagamento);

  }


  @Override
  public void remover(FormaPagamento formaPagamento) {
    formaPagamento = this.buscar(formaPagamento.getId());
    this.manager.remove(formaPagamento);

  }

}
