package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.model.input.CidadeInput;
import com.algaworks.algafood.domain.model.Cidade;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CidadeInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public Cidade toDomainObject(CidadeInput cidadeInput) {

        return modelMapper.map(cidadeInput, Cidade.class);

    }

    public void copyDomainObject(CidadeInput cidadeInput, Cidade cidade) {

        entityManager.detach(cidade.getEstado());
        modelMapper.map(cidadeInput, cidade);
    }
}
