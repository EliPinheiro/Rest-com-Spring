package com.eli.eli_food.jpa.cidade;

import java.util.List;


import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.eli.eli_food.ElifoodApiApplication;
import com.eli.eli_food.domain.model.Cidade;
import com.eli.eli_food.domain.repository.CidadeRepository;

public class ConsultaCidadeMain {

    public static void main(String[] args) {
    	ConfigurableApplicationContext applicationContext =  new SpringApplicationBuilder(ElifoodApiApplication.class)
                .run(args);
        
        CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
        
        List<Cidade> todasCidades = cidadeRepository.listar();
        
        for (Cidade cidade : todasCidades) {
            System.out.printf("%s - %s\n", cidade.getNome(), cidade.getEstado().getNome());
        }
    }
    
}
