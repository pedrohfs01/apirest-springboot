package com.pedrofernandes.apirestpedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedrofernandes.apirestpedidos.services.S3Service;

@SpringBootApplication
public class ApirestPedidosApplication implements CommandLineRunner{
	
	@Autowired
	S3Service s3Service;
	
	public static void main(String[] args) {
		SpringApplication.run(ApirestPedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		s3Service.uploadFile("//home//basis//Documents//Imagens//img1.jpg");
	}
}
