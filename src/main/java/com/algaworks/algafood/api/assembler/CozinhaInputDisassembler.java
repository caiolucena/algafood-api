package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.model.input.CozinhaInput;
import com.algaworks.algafood.domain.model.Cozinha;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CozinhaInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public Cozinha toDomainObject(CozinhaInput cozinhaInput) {

        return modelMapper.map(cozinhaInput, Cozinha.class);

    }

    public void copyDomainObject(CozinhaInput cozinhaInput, Cozinha cozinha ){

        modelMapper.map(cozinhaInput, cozinha);
    }
}
