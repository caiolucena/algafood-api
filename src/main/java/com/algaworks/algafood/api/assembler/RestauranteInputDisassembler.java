package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.model.input.RestauranteInput;
import com.algaworks.algafood.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class RestauranteInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public Restaurante toDomainObject(RestauranteInput restauranteInput) {

        return modelMapper.map(restauranteInput, Restaurante.class);

    }

    public void copyDomainObject(RestauranteInput restauranteInput,Restaurante restaurante ){

        /**
         * Sem essa linha abaixo, lancaria essa exceção
         * Caused by: org.hibernate.HibernateException: identifier of an instance of com.algaworks.algafood.domain.model.Cozinha was altered from 1 to 2
         * restaurante.setCozinha(new Cozinha());
         * Aula 11.17. Mapeando para uma instância destino (e não um tipo) com ModelMapper
         */
        entityManager.detach(restaurante.getCozinha());
        modelMapper.map(restauranteInput, restaurante);
    }
}
