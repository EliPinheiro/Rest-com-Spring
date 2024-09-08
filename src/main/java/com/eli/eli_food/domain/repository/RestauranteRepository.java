package com.eli.eli_food.domain.repository;

import java.util.List;

import com.eli.eli_food.domain.model.Cozinha;
import com.eli.eli_food.domain.model.Restaurante;

public interface RestauranteRepository {

	List<Restaurante> listar();
	Restaurante buscarRestaurante(Long id);
	Restaurante adicionar(Restaurante restaurante);
	void remover(Long id);
	
}