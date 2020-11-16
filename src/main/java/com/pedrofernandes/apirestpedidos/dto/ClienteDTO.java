package com.pedrofernandes.apirestpedidos.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.pedrofernandes.apirestpedidos.domain.Cliente;
import com.pedrofernandes.apirestpedidos.services.validation.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Campo vázio, preencha-o.")
	@Length(min=5, max=80, message="O tamanho deve ser de 5 a 120 caractéres")	
	private String nome;
	
	@NotEmpty(message="Campo vázio, preencha-o.")
	@Email(message="Email inválido")
	private String email;
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
