package com.eli.eli_food.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.eli.eli_food.domain.model.Cozinha;
import com.eli.eli_food.domain.repository.CozinhaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository{

	@PersistenceContext
	private EntityManager manager; //O entityManager é uma interface que faz a intermediação ,gerencia o contexto de persistencia

	@Override
	public List<Cozinha> listar(){
		TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class); // Aqui o manager está fazendo uma consult usando o JPQL;
		return query.getResultList();	
	}
	
	@Override
	@Transactional //Todo o método que vai modicar o banco de dados de alguma form precisa ter essa anotação
	public Cozinha adicionar(Cozinha cozinha) {
		return manager.merge(cozinha); //Esse metodo merge é como o salvar. Nesse exemplo a cozinha não tem Id pois ainda não foi para o banco de dados, mas quando o merge inseri ele lá ela recebe um id.
	}
	
	@Override
	public Cozinha buscarCozinha(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	@Override
	@Transactional
	public void remover(Long id) {
		Cozinha cozinha = buscarCozinha(id);
		
		if (cozinha == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(cozinha);
	}
	
}
