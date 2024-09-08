package com.eli.eli_food.jpa.permissao;

import java.util.List;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.eli.eli_food.ElifoodApiApplication;
import com.eli.eli_food.domain.model.Permissao;
import com.eli.eli_food.domain.repository.PermissaoRepository;

public class ConsultaPermissaoMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(ElifoodApiApplication.class)
                .run(args);
        
        PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);
        
        List<Permissao> todasPermissoes = permissaoRepository.listar();
        
        for (Permissao permissao : todasPermissoes) {
            System.out.printf("%s - %s\n", permissao.getNome(), permissao.getDescricao());
        }
    }
    
}
