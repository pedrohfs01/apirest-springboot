package com.pedrofernandes.apirestpedidos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrofernandes.apirestpedidos.domain.Categoria;
import com.pedrofernandes.apirestpedidos.repositories.CategoriaRepository;
import com.pedrofernandes.apirestpedidos.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Id "+id+" não encontrado. Tipo: "+Categoria.class.getName()));
	}
	
}
