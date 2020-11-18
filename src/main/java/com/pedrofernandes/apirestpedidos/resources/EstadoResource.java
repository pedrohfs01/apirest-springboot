package com.pedrofernandes.apirestpedidos.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrofernandes.apirestpedidos.domain.Cidade;
import com.pedrofernandes.apirestpedidos.domain.Estado;
import com.pedrofernandes.apirestpedidos.dto.CidadeDTO;
import com.pedrofernandes.apirestpedidos.dto.EstadoDTO;
import com.pedrofernandes.apirestpedidos.services.CidadeService;
import com.pedrofernandes.apirestpedidos.services.EstadoService;

@RestController
@RequestMapping(value= "/estados")
public class EstadoResource {

	@Autowired
	EstadoService service;
	
	@Autowired
	CidadeService cidService;
	
	@GetMapping()
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> list = service.findAll();
		List<EstadoDTO> listDTO = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value="/{estadoId}/cidades")
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId){
		List<Cidade> list = cidService.findCidades(estadoId);
		
		List<CidadeDTO> listDTO = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
