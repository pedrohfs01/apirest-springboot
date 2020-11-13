package com.pedrofernandes.apirestpedidos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrofernandes.apirestpedidos.domain.Pedido;
import com.pedrofernandes.apirestpedidos.repositories.PedidoRepository;
import com.pedrofernandes.apirestpedidos.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Id "+id+" não encontrado. Tipo: "+Pedido.class.getName()));
	}
	
}
