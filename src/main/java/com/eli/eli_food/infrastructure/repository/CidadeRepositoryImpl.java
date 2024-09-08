package com.eli.eli_food.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.eli.eli_food.domain.model.Cidade;
import com.eli.eli_food.domain.repository.CidadeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

    @PersistenceContext
    private EntityManager manager;
    
    @Override
    public List<Cidade> listar() {
        return manager.createQuery("from Cidade", Cidade.class)
                .getResultList();
    }
    
    @Override
    public Cidade buscar(Long id) {
        return manager.find(Cidade.class, id);
    }
    
    @Transactional
    @Override
    public Cidade salvar(Cidade cidade) {
        return manager.merge(cidade);
    }
    
    @Transactional
    @Override
    public void remover(Cidade cidade) {
        cidade = buscar(cidade.getId());
        manager.remove(cidade);
    }
}