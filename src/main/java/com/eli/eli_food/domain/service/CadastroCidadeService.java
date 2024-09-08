package com.eli.eli_food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eli.eli_food.domain.exception.EntidadeNaoEncontradaException;
import com.eli.eli_food.domain.model.Cidade;
import com.eli.eli_food.domain.model.Estado;
import com.eli.eli_food.domain.repository.CidadeRepository;
import com.eli.eli_food.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.buscar(estadoId);
		
		if (estado == null) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe estado com o id %d", estadoId));
		}
		cidade.setEstado(estado);
		
		
		
		return cidadeRepository.salvar(cidade);
	}

	public void deletar(Long id) {
		Cidade cidade = cidadeRepository.buscar(id);
		if (cidade == null) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe cidade cadastrada com esse o id %d.", id));
		}
		cidadeRepository.remover(cidade);;
		
	}
	
	
	
}
