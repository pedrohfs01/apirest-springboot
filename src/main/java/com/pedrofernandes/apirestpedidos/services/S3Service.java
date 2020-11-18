package com.pedrofernandes.apirestpedidos.services;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> ea3f78d57fb8c8bdcb024eb09baa9de6a08e1ad2
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
=======
import java.io.File;
>>>>>>> parent of 9d5ac2d... Adicionando imagem via endpoint
=======
import java.io.File;
>>>>>>> parent of 9d5ac2d... Adicionando imagem via endpoint
<<<<<<< HEAD
=======
import java.io.File;
>>>>>>> parent of 9d5ac2d... Adicionando imagem via endpoint
=======
>>>>>>> ea3f78d57fb8c8bdcb024eb09baa9de6a08e1ad2

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> ea3f78d57fb8c8bdcb024eb09baa9de6a08e1ad2
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.pedrofernandes.apirestpedidos.services.exception.FileException;
=======
import com.amazonaws.services.s3.model.PutObjectRequest;
>>>>>>> parent of 9d5ac2d... Adicionando imagem via endpoint
=======
import com.amazonaws.services.s3.model.PutObjectRequest;
>>>>>>> parent of 9d5ac2d... Adicionando imagem via endpoint
<<<<<<< HEAD
=======
import com.amazonaws.services.s3.model.PutObjectRequest;
>>>>>>> parent of 9d5ac2d... Adicionando imagem via endpoint
=======
>>>>>>> ea3f78d57fb8c8bdcb024eb09baa9de6a08e1ad2

@Service
public class S3Service {

	private Logger LOG = LoggerFactory.getLogger(S3Service.class);
	
	@Autowired
	private AmazonS3 s3client;
	
	@Value("${s3.bucket}")
	private String bucketName;
	
	public void uploadFile(String localPathFile) {
		try {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> ea3f78d57fb8c8bdcb024eb09baa9de6a08e1ad2
			String fileName = multipartFile.getOriginalFilename();
			InputStream is = multipartFile.getInputStream();
			String contentType = multipartFile.getContentType();
			return uploadFile(is, fileName, contentType);
		} catch (IOException e) {
			throw new RuntimeException("Erro de IO.  "+e.getMessage());
		}
		
	}

	public URI uploadFile(InputStream is, String fileName, String contentType) {
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);
=======
			File file = new File(localPathFile);
>>>>>>> parent of 9d5ac2d... Adicionando imagem via endpoint
			LOG.info("Iniciando Upload");
			s3client.putObject(new PutObjectRequest(bucketName, "Teste", file));
			LOG.info("Finalizado Upload");
<<<<<<< HEAD

			return s3client.getUrl(bucketName, fileName).toURI();
		} catch (URISyntaxException e) {
			throw new FileException("Erro ao converter URL para URI");
=======
=======
			File file = new File(localPathFile);
			LOG.info("Iniciando Upload");
			s3client.putObject(new PutObjectRequest(bucketName, "Teste", file));
			LOG.info("Finalizado Upload");
>>>>>>> parent of 9d5ac2d... Adicionando imagem via endpoint
<<<<<<< HEAD
=======
			File file = new File(localPathFile);
			LOG.info("Iniciando Upload");
			s3client.putObject(new PutObjectRequest(bucketName, "Teste", file));
			LOG.info("Finalizado Upload");
>>>>>>> parent of 9d5ac2d... Adicionando imagem via endpoint
=======
>>>>>>> ea3f78d57fb8c8bdcb024eb09baa9de6a08e1ad2
			
		}catch(AmazonServiceException e) {
			LOG.info(e.getErrorMessage());
			LOG.info("Status Code:" +e.getErrorCode());
		}catch(AmazonClientException e) {
			LOG.info(e.getMessage());
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 9d5ac2d... Adicionando imagem via endpoint
=======
=======
>>>>>>> ea3f78d57fb8c8bdcb024eb09baa9de6a08e1ad2
>>>>>>> parent of 9d5ac2d... Adicionando imagem via endpoint
=======
>>>>>>> parent of 9d5ac2d... Adicionando imagem via endpoint
		}
	}
}
