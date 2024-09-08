package com.eli.eli_food.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.eli.eli_food.domain.model.Restaurante;
import com.eli.eli_food.domain.repository.RestauranteRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository{

	@PersistenceContext
	private EntityManager manager; //O entityManager é uma interface que faz a intermediação ,gerencia o contexto de persistencia

	@Override
	public List<Restaurante> listar(){
		TypedQuery<Restaurante> query = manager.createQuery("from Restaurante", Restaurante.class); // Aqui o manager está fazendo uma consult usando o JPQL;
		return query.getResultList();	
	}
	
	@Override
	@Transactional //Todo o método que vai modicar o banco de dados de alguma form precisa ter essa anotação
	public Restaurante adicionar(Restaurante restaurante) {
		return manager.merge(restaurante); //Esse metodo merge é como o salvar. Nesse exemplo a cozinha não tem Id pois ainda não foi para o banco de dados, mas quando o merge inseri ele lá ela recebe um id.
	}
	
	@Override
	public Restaurante buscarRestaurante(Long id) {
		return manager.find(Restaurante.class, id);
	}
	@Override
	@Transactional
	public void remover(Long id) {
		Restaurante restaurante = buscarRestaurante(id);
		manager.remove(restaurante);
	}
	
}