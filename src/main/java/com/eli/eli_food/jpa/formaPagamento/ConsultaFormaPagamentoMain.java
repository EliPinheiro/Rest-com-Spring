package com.eli.eli_food.jpa.formaPagamento;

import java.util.List;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.eli.eli_food.ElifoodApiApplication;
import com.eli.eli_food.domain.model.FormaPagamento;
import com.eli.eli_food.domain.repository.FormaPagamentoRepository;

public class ConsultaFormaPagamentoMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(ElifoodApiApplication.class)
                .run(args);
        
        FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
        
        List<FormaPagamento> todasFormasPagamentos = formaPagamentoRepository.listar();
        
        for (FormaPagamento formaPagamento : todasFormasPagamentos) {
            System.out.println(formaPagamento.getDescricao());
        }
    }
    
}
