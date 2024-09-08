package com.eli.eli_food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Essa anotação tem outra anotação chamada componentScan que analisa todo o projeto na inicialização 
//da aplicação para saber quais classes serão gerenciadas pelo container do Spring.
@SpringBootApplication public class ElifoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElifoodApiApplication.class, args);
	}

}
