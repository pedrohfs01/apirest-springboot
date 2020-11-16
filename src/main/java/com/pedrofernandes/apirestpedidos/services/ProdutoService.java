package com.pedrofernandes.apirestpedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pedrofernandes.apirestpedidos.domain.Categoria;
import com.pedrofernandes.apirestpedidos.domain.Produto;
import com.pedrofernandes.apirestpedidos.repositories.CategoriaRepository;
import com.pedrofernandes.apirestpedidos.repositories.ProdutoRepository;
import com.pedrofernandes.apirestpedidos.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	@Autowired
	private CategoriaRepository catRepo;

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Id " + id + " não encontrado. Tipo: " + Produto.class.getName()));
	}

	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy,
			String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		List<Categoria> categorias = catRepo.findAllById(ids);
		
		return repo.findDistinctByNomeContainingIgnoreCaseAndCategoriasIn(nome, categorias, pageRequest);
	}
}
