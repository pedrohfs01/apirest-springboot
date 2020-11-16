package com.pedrofernandes.apirestpedidos.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.pedrofernandes.apirestpedidos.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instante) {
		Calendar car = Calendar.getInstance();
		car.setTime(instante);
		car.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(car.getTime());
	}
}
