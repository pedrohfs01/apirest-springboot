package com.pedrofernandes.apirestpedidos.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pedrofernandes.apirestpedidos.domain.Categoria;
import com.pedrofernandes.apirestpedidos.repositories.CategoriaRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	}
}
