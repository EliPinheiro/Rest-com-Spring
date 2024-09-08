package com.eli.eli_food.domain.repository;

import java.util.List;

import com.eli.eli_food.domain.model.Cozinha;

public interface CozinhaRepository {

	List<Cozinha> listar();
	Cozinha buscarCozinha(Long id);
	Cozinha adicionar(Cozinha cozinha);
	void remover(Long id);
	
}