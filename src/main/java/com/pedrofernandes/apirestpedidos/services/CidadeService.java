package com.pedrofernandes.apirestpedidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrofernandes.apirestpedidos.domain.Cidade;
import com.pedrofernandes.apirestpedidos.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository repo;
	
	
	public List<Cidade> findCidades(Integer id) {
		return repo.findCidades(id);
	}
}
