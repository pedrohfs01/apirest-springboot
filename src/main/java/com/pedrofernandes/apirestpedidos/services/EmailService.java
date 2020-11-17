package com.pedrofernandes.apirestpedidos.services;

import org.springframework.mail.SimpleMailMessage;

import com.pedrofernandes.apirestpedidos.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
