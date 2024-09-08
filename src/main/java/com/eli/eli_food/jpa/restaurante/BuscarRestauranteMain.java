package com.eli.eli_food.jpa.restaurante;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.eli.eli_food.ElifoodApiApplication;
import com.eli.eli_food.domain.model.Cozinha;
import com.eli.eli_food.domain.model.Restaurante;
import com.eli.eli_food.domain.repository.CozinhaRepository;
import com.eli.eli_food.domain.repository.RestauranteRepository;

// Essa classe vai inicializar um aplicação no spring, sem precisar dela ser WEB;
public class BuscarRestauranteMain {

	public static void main(String[] args) {
		
		/*
		 *  Esse código é utilizado para iniciar uma aplicação Spring Boot sem um servidor web embutido,
		 *  o que é útil para aplicações que não são serviços web, 
		 *  como aplicações de linha de comando ou processos em segundo plano.
		 */
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(ElifoodApiApplication.class) //ConfigurableApplicationContext é uma interface que representa o contexto da aplicação Spring. Ele é responsável por gerenciar os beans, o ciclo de vida da aplicação, e outros recursos do Spring. Ao armazenar o contexto em uma variável, você pode acessar e manipular os beans ou realizar outras operações após a inicialização da aplicação.
				.run(args);
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante = restauranteRepository.buscarRestaurante(1L);
		
		System.out.println(restaurante.getNome());
		System.out.println(restaurante.getCozinha().getNome());
	}
	
}
