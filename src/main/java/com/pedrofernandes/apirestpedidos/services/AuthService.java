package com.pedrofernandes.apirestpedidos.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pedrofernandes.apirestpedidos.domain.Cliente;
import com.pedrofernandes.apirestpedidos.repositories.ClienteRepository;
import com.pedrofernandes.apirestpedidos.services.exception.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	BCryptPasswordEncoder pe;
	
	@Autowired
	EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		Cliente cliente = clienteRepository.findByEmail(email);
		if(cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = newPassword();
		cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
	}

	private String newPassword() {
		char[] vet = new char[10];
		
		for(int i = 0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if(opt == 1){//gera digito
			return (char) (rand.nextInt(10)+48);
		}else if(opt == 2) {//gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		}else {//gera letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}
	}
}
